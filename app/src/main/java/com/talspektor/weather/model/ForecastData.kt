package com.talspektor.weather.model

import com.google.gson.annotations.SerializedName

data class ForecastData(
    @SerializedName("list") var list: ForecastList? = null
)

data class ForecastList(
    @SerializedName("main") var main: Main? = null,
    @SerializedName("weather") var weather: Weather? = null,
    @SerializedName("clouds") var clouds: Clouds? = null,
    @SerializedName("wind") var wind: Wind? = null,
    @SerializedName("rain") var rain: Rain? = null,
    @SerializedName("Snow") var snow: Snow? = null,
    @SerializedName("visibility") var visibility: Int? = null,
    @SerializedName("dt_txt") var dateString: String? = null,
    @SerializedName("city") var city: City? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("timezone") var timezone: Int? = null,
    @SerializedName("sunrise") var sunrise: Long? = null,
    @SerializedName("sunset") var sunset: Long? = null
)

data class Rain(
    @SerializedName("h1") var h1: Double? = null
)

data class Snow(
    @SerializedName("Snow") var h1: Double? = null
)

data class City(
    @SerializedName("id") var id: Long? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("coord") var coord: Coord? = null
)