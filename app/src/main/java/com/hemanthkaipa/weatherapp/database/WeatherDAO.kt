package com.hemanthkaipa.weatherapp.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hemanthkaipa.weatherapp.database.WeatherEntity

@Dao
/**
 * Data Access Object interface DAO interface gives access to all the methods to outside world to access
 * DB
 *
 */

interface WeatherDAO {
    @Insert
    suspend fun insertWeatherForecast(data : WeatherEntity) : Long

    @Update
    suspend fun updateWeatherForecast(data: WeatherEntity)


    @Query("SELECT * FROM weather_table")
    fun fetchAllWeatherForecast() : LiveData<WeatherEntity>


}