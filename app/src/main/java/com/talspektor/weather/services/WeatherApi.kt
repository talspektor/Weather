package com.talspektor.weather.services

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherApi(prefix: UrlPrefix) {

    enum class UrlPrefix(val prefix: String) {
        API("api"),
        PRO("pro")
    }

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder().apply {
        this.addInterceptor(interceptor)
    }.build()

    private val  mBaseUrl = "https://$prefix.openweathermap.org/data/2.5/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(mBaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

}