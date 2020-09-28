package com.talspektor.weather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.talspektor.weather.model.WeatherData
import com.talspektor.weather.services.GetWeatherData
import com.talspektor.weather.services.WeatherApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = WeatherApi()
        val retrofit = api.retrofit

        val service = retrofit.create(GetWeatherData::class.java)
        val call = service.loadWeatherData("data/2.5/weather/?q=London&appid=${Const.KEY}")
        Log.d("call", "URL: ${call.request()}")

        call.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                Log.d("onResponse", "response: ${response.body().toString()}")
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                Log.d("onFailure", "fail")
            }
        })

    }
}
// key
//a8988c436c0a8a587b08b3e4a2e84b2f

