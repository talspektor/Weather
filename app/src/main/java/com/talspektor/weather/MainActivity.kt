package com.talspektor.weather

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.talspektor.weather.fragments.DetailsFragment
import com.talspektor.weather.fragments.ViewPager
import com.talspektor.weather.model.WeatherData
import com.talspektor.weather.services.GetWeatherData
import com.talspektor.weather.services.WeatherApi
import kotlinx.android.synthetic.main.view_pager.*

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = ViewPager(supportFragmentManager, DetailsFragment.newInstance())
        viewPager.adapter = pagerAdapter
    }
}

