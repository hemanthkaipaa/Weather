package com.hemanthkaipa.weatherapp.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.hemanthkaipa.weatherapp.R
import com.hemanthkaipa.weatherapp.database.WeatherDB
import com.hemanthkaipa.weatherapp.databinding.ActivityMainBinding

class WeatherActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        val dao  = WeatherDB.getInstance(this).weatherDAO
        binding.viewmModel = WeatherViewModel(dao)
        binding.lifecycleOwner = this
        requestWeatherData();
    }

    fun requestWeatherData(){
        binding.viewmModel.callWeatherData()
    }
}