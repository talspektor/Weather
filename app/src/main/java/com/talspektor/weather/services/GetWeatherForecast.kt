package com.talspektor.weather.services

import com.talspektor.weather.Keys
import com.talspektor.weather.model.CityWeatherData
import com.talspektor.weather.model.ForecastData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetWeatherForecast {

    @GET("hourly")
    fun getHourlyForecastByCityName(@Query("q") cityName: String,
                                 @Query("unit") unit: OutPutUnit = OutPutUnit.METRIC,
                                 @Query("lang") language: OutPutLanguage = OutPutLanguage.ENGLISH,
                                 @Query("appid") appId: String = Keys.KEY): Call<ForecastData>

    @GET("hourly")
    fun getHourlyForecastByCityId(@Query("id") cityId: String,
                                 @Query("unit") unit: OutPutUnit = OutPutUnit.METRIC,
                                 @Query("lang") language: OutPutLanguage = OutPutLanguage.ENGLISH,
                                 @Query("appid") appId: String = Keys.KEY): Call<ForecastData>
}