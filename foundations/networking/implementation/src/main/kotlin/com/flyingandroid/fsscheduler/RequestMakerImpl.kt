package com.flyingandroid.fsscheduler

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.*
import java.io.IOException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class RequestMakerImpl(
    private val okHttpClient: OkHttpClient
) : RequestMaker {
    override suspend fun <T : Any> get(url: String, adapter: JsonAdapter<T>): T {
        val request: Request = Request.Builder()
            .url(url)
            .build()
        val call = okHttpClient.newCall(request)
        call.await().use { response ->
            val body = response.body
            println("Response Code: ${response.code}")
            if (response.isSuccessful && body != null) {
                return adapter.fromJson(body.string()) ?: throw RuntimeException("Fix later")
            }
        }
        throw RuntimeException("Fix later")
    }

    private suspend inline fun Call.await(): Response {
        return suspendCancellableCoroutine { continuation ->
            val callback = ContinuationCallback(this, continuation)
            enqueue(callback)
            continuation.invokeOnCancellation(callback)
        }
    }

    // From: https://github.com/coil-kt/coil/blob/a17284794764ed5d0680330bfd8bca722a36bb5e/coil-base/src/main/java/coil/util/ContinuationCallback.kt
    internal class ContinuationCallback(
        private val call: Call,
        private val continuation: CancellableContinuation<Response>
    ) : Callback, CompletionHandler {

        override fun onResponse(call: Call, response: Response) {
            continuation.resume(response)
        }

        override fun onFailure(call: Call, e: IOException) {
            if (!call.isCanceled()) {
                continuation.resumeWithException(e)
            }
        }

        override fun invoke(cause: Throwable?) {
            try {
                call.cancel()
            } catch (_: Throwable) {
            }
        }
    }

    class BuilderImpl(
        private val okHttpClient: OkHttpClient,
    ) : RequestMaker.Builder {
        private val interceptors: MutableSet<RequestInterceptor> = mutableSetOf()

        override fun addInterceptor(networkInterceptor: RequestInterceptor): RequestMaker.Builder {
            interceptors += networkInterceptor
            return this
        }

        override fun build(): RequestMaker {
            return RequestMakerImpl(
                okHttpClient.newBuilder()
                    .addInterceptor(CompositeInterceptor(interceptors))
                    .build()
            )
        }
    }
}