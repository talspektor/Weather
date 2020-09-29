package com.talspektor.weather.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.talspektor.weather.Keys
import com.talspektor.weather.R
import com.talspektor.weather.controllers.DetailsWeatherAdapter
import com.talspektor.weather.model.WeatherData
import com.talspektor.weather.services.GetWeatherData
import com.talspektor.weather.services.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: DetailsViewModel
    private lateinit var recyclerAdapter: DetailsWeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        context?.let {
            recyclerAdapter = DetailsWeatherAdapter(it, viewModel.weatherItems)
        }
        // TODO: Use the ViewModel

        val api = WeatherApi()
        val retrofit = api.retrofit

        val service = retrofit.create(GetWeatherData::class.java)
        val call = service.loadWeatherData("?q=London&appid=${Keys.KEY}")
        Log.d("call", "URL: ${call.request()}")

        call.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                val weatherModel = response.body()
                weatherModel?.let {
                    viewModel.weatherItems?.add(weatherModel)
                }
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                Log.d("onFailure", "fail")
            }
        })
    }

}