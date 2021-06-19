package com.hemanthkaipa.weatherapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    var id: Int,
    @ColumnInfo(name = "lon")
    var latitude: Double,
    @ColumnInfo(name = "lat")
    var longitude: Double,
    @ColumnInfo(name = "temp")
    var temperature: Double,
    @ColumnInfo(name = "feels_like")
    var feelsLike: Double,
    @ColumnInfo(name = "temp_min")
    var temp_min: Double,
    @ColumnInfo(name = "temp_max")
    var temp_max: Double,
    @ColumnInfo(name = "pressure")
    var pressure: Int,
    @ColumnInfo(name = "humidity")
    var humidity: Int,
    @ColumnInfo(name = "sea_level")
    var sea_level: Int,
    @ColumnInfo(name = "speed")
    var windSpeed: Double,
    @ColumnInfo(name = "name")
    var City: String,
)