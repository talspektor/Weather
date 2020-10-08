package com.talspektor.weather.services

import com.talspektor.weather.Keys
import retrofit2.Call
import com.talspektor.weather.model.CityWeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface GetCurrentWeatherData {
    @GET("weather")
    fun getCityByNameWeather(@Query("q") cityName: String,
                             @Query("unit") unit: OutPutUnit = OutPutUnit.METRIC,
                             @Query("lang") language: OutPutLanguage = OutPutLanguage.ENGLISH,
                             @Query("appid") appId: String = Keys.KEY): Call<CityWeatherData>
    @GET("weather")
    fun getCityByIdWeather(@Query("id") cityId: String,
                           @Query("unit") unit: OutPutUnit = OutPutUnit.METRIC,
                           @Query("lang") language: OutPutLanguage = OutPutLanguage.ENGLISH,
                           @Query("appid") appId: String = Keys.KEY): Call<CityWeatherData>
}

enum class OutPutLanguage(val lang: String) {
    Hebrew("he"),
    ENGLISH("en")
}

enum class OutPutUnit(val unit: String) {
    METRIC("metric"),
    IMPERIAL("imperial"),
    STANDARD("standard")
}