package com.talspektor.weather.fragments

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import com.talspektor.weather.model.WeatherData

class DetailsViewModel : ViewModel() {

    lateinit var weatherItems: MutableList<WeatherData>
}