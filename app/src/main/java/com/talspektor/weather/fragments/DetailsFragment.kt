package com.talspektor.weather.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.talspektor.weather.R
import com.talspektor.weather.controllers.DetailsWeatherAdapter
import com.talspektor.weather.model.CityWeatherData
import com.talspektor.weather.model.ForecastData
import com.talspektor.weather.model.ForecastList
import com.talspektor.weather.services.GetCurrentWeatherData
import com.talspektor.weather.services.GetWeatherForecast
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
//            recyclerAdapter = DetailsWeatherAdapter(it, viewModel.weatherItems)
        }
        // TODO: Use the ViewModel

        val api = WeatherApi(WeatherApi.UrlPrefix.API)
        val retrofit = api.retrofit

        val service = retrofit.create(GetCurrentWeatherData::class.java)
        val forecastService = retrofit.create(GetWeatherForecast::class.java)
        val call = service.getCityByNameWeather("London")
        val call2 = forecastService.getHourlyForecastByCityName("London")

        Log.d("call", "URL: ${call.request()}")
        Log.d("forecastService", "URL: ${call2.request().url.toUri()}")

        call2.enqueue(object : Callback<ForecastData>{
            override fun onFailure(call: Call<ForecastData>, t: Throwable) {
                Log.d("onFailure", "fail")
            }

            override fun onResponse(
                call: Call<ForecastData>,
                response: Response<ForecastData>
            ) {
                val weatherModel = response.body()
                weatherModel?.let {
                    print(weatherModel.toString())
                }
            }

        })


//        call.enqueue(object : Callback<CityWeatherData> {
//            override fun onResponse(call: Call<CityWeatherData>, response: Response<CityWeatherData>) {
//                val weatherModel = response.body()
//                weatherModel?.let {
//                    viewModel.weatherItems?.add(weatherModel)
//                }
//            }
//
//            override fun onFailure(call: Call<CityWeatherData>, t: Throwable) {
//                Log.d("onFailure", "fail")
//            }
//        })
    }

}