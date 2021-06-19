package com.hemanthkaipa.weatherapp.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkInstance {
    companion object {

        const val APIKEY = "0b56237d07c174fc57c4d86b64aa7c67"
        const val UNITS = "metric"
        private const val RetroBaseURL = "https://api.openweathermap.org/data/2.5/"
        fun getRetrofitInstance() : Retrofit{
            val gsonFactory = GsonConverterFactory.create(GsonBuilder().create())
            return Retrofit.Builder().baseUrl(RetroBaseURL)
                .addConverterFactory(gsonFactory)
                .build()
        }
    }
}