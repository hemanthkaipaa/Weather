package com.hemanthkaipa.weatherapp.weather

import androidx.databinding.Observable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemanthkaipa.weatherapp.database.WeatherDAO
import kotlinx.coroutines.async

class WeatherViewModel(dao: WeatherDAO) : ViewModel(), Observable {
    private var repo : WeatherRepo = WeatherRepo(dao)
    fun callWeatherData() {
        val result = viewModelScope.async {
            repo.initRest(15.4668, 78.4875)
        }
    }

    fun fetchWeatherData(){

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}