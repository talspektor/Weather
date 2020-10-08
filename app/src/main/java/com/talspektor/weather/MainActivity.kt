package com.talspektor.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.talspektor.weather.fragments.DetailsFragment
import com.talspektor.weather.fragments.ViewPager
import kotlinx.android.synthetic.main.view_pager.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagerAdapter = ViewPager(supportFragmentManager, DetailsFragment.newInstance())
        viewPager.adapter = pagerAdapter
    }
}

