package com.flyingandroid.fsscheduler

interface RequestMaker {
    suspend fun <T: Any> get(url: String, klass: Class<T>): T
}