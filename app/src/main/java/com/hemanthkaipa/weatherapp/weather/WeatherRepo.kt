package com.hemanthkaipa.weatherapp.weather

import com.hemanthkaipa.weatherapp.database.WeatherDAO
import com.hemanthkaipa.weatherapp.network.WeatherApi
import com.hemanthkaipa.weatherapp.network.NetworkInstance
import com.hemanthkaipa.weatherapp.database.WeatherEntity
import com.hemanthkaipa.weatherapp.weather.model.WeatherModel
import retrofit2.create

class WeatherRepo(private val weatherDAO: WeatherDAO) {

    val fetchWeatherData = weatherDAO.fetchAllWeatherForecast()

    suspend fun initRest(latitude:Double, longitude:Double){
        val networkService = NetworkInstance.getRetrofitInstance().create<WeatherApi>()
        val response = networkService.getWeatherData(latitude, longitude)
        val weatherData : WeatherModel? = response.body()
        if (weatherData != null) {
            val weatherEntity =WeatherEntity(
                1,
                weatherData.coord.lon,
                weatherData.coord.lat,
                weatherData.main.temp,
                weatherData.main.feelsLike,
                weatherData.main.tempMin,
                weatherData.main.tempMax,
                weatherData.main.pressure,
                weatherData.main.humidity,
                weatherData.main.seaLevel,
                weatherData.wind.speed,
                weatherData.name

            )
            insertWeather(weatherEntity)
        }
    }


    private suspend fun insertWeather(entity: WeatherEntity){
        weatherDAO.insertWeatherForecast(entity);
    }
    suspend fun updateWeather(entity: WeatherEntity){
        weatherDAO.updateWeatherForecast(entity)
    }

}