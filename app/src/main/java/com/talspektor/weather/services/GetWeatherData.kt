package com.talspektor.weather.services

import retrofit2.Call
import com.talspektor.weather.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Url

interface GetWeatherData {
    @GET
    fun loadWeatherData(@Url cityName: String): Call<WeatherData>
}