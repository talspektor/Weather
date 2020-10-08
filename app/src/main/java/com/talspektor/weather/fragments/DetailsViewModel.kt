package com.talspektor.weather.fragments

import androidx.lifecycle.ViewModel
import com.talspektor.weather.model.CityWeatherData

class DetailsViewModel : ViewModel() {

    lateinit var weatherItems: MutableList<CityWeatherData>
}