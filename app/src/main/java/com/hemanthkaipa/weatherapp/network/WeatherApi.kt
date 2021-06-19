package com.hemanthkaipa.weatherapp.network

import com.hemanthkaipa.weatherapp.weather.model.WeatherModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeatherData(@Query("lat")lat:Double,
                       @Query("lon")longi:Double,
                       @Query("appid")appid:String=NetworkInstance.APIKEY,
                       @Query("units")units:String=NetworkInstance.UNITS
    ): Response<WeatherModel>

}