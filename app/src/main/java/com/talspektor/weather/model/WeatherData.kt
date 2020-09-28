package com.talspektor.weather.model

import com.google.gson.annotations.SerializedName

class WeatherData {

    @SerializedName("coord")
    var coord: Coord? = null

    @SerializedName("weather")
    var weather: Array<Weather>? = null

    @SerializedName("base")
    var base: String? = null

    @SerializedName("main")
    var main: Main? = null

    @SerializedName("visibility")
    var visibility: Int? = null

    @SerializedName("wind")
    var wind: Wind? = null

    @SerializedName("clouds")
    var clouds: Clouds? = null

    @SerializedName("dt")
    var dt: Long? = null

    @SerializedName("sys")
    var sys: Sys? = null

    @SerializedName("timezone")
    var timezone: Int? = null

    @SerializedName("id")
    var id: Long? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("cod")
    var cod: Int? = null
}

class Coord {
    @SerializedName("lon")
    var lon: Double? = 0.0
    @SerializedName("lat")
    var lat: Double? = 0.0
}

class Weather {
    @SerializedName("id")
    var id: Int? = 0
    @SerializedName("main")
    var main: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("icon")
    var icon: String? = null
}

class Main {
    @SerializedName("temp")
    var temp: Double? = null
    @SerializedName("feels_like")
    var feelsLike: Double? = null
    @SerializedName("temp_min")
    var tempMin: Double? = null
    @SerializedName("temp_max")
    var tempMax: Double? = null
    @SerializedName("pressure")
    var pressure: Int? = null
    @SerializedName("humidity")
    var humidity: Int? = null
}

class Wind {
    @SerializedName("speed")
    var speed: Double? = null
    @SerializedName("deg")
    var deg: Int? = null
}

class Clouds {
    @SerializedName("all")
    var all: Int? = null
}

class Sys {
    @SerializedName("type")
    var type: Int? = null
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("country")
    var country: String? = null
    @SerializedName("sunrise")
    var sunrise: Long? = null
    @SerializedName("sunset")
    var sunset: Long? = null
}