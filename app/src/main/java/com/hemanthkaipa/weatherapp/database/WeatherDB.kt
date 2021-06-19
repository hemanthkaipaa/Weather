package com.hemanthkaipa.weatherapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WeatherEntity::class], version = 1)
abstract class WeatherDB : RoomDatabase() {
    abstract val weatherDAO: WeatherDAO
    companion object{
        fun getInstance(context: Context): WeatherDB {
            synchronized(this) {
                var instance: WeatherDB? = null
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        WeatherDB::class.java,
                        "weather_database"
                    ).build()
                }
                return instance
            }
        }
    }

}