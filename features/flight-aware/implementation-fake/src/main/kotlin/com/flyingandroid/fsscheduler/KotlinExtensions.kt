package com.flyingandroid.fsscheduler

import com.squareup.moshi.JsonReader
import okio.BufferedSource
import okio.buffer
import okio.source
import java.io.InputStream

internal fun InputStream.toJsonReader(): JsonReader {
    return JsonReader.of(source().buffer())
}

internal fun Any.loadFromResources(path: String): BufferedSource {
    return this::class.java
        .classLoader
        .getResourceAsStream(
            path
        ).source().buffer()
}