package com.jobs.assignment.network

import okhttp3.*

class SupportInterceptor : Interceptor, Authenticator {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url: String = request.url.toString()

        request = when {
            url.contains("user") -> {
                request.newBuilder()
                    .addHeader("Content-Type", "applicationUrlEncode")
                    .addHeader("Authorization", "authorization")
                    .build()
            }
            else -> {
                request.newBuilder()
                    .build()
            }
        }
        return chain.proceed(request)
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        //can implement 401 case here
        return null
    }
}