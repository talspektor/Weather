package com.talspektor.weather.controllers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.talspektor.weather.R
import com.talspektor.weather.model.CityWeatherData
import kotlinx.android.synthetic.main.weather_item.view.*

class DetailsWeatherAdapter(private val context: Context, private var weatherItems: List<CityWeatherData>?): RecyclerView.Adapter<DetailsWeatherAdapter.ViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.weather_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        weatherItems?.let {
            return it.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weatherItem = weatherItems?.get(index = position)
        holder.title.text = weatherItem?.base
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        lateinit var title: TextView

        init {
            itemView.titleTextView?.let {
                title = it
            }
        }
    }
}