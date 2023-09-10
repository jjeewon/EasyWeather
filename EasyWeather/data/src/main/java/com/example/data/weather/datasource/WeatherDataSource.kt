package com.example.data.weather.datasource

import com.example.data.weather.model.FutureWeatherDataModel
import com.example.data.weather.model.WeatherDataModel

interface WeatherDataSource {
    suspend fun getWeather(q: String): WeatherDataModel

    suspend fun getFutureWeather(q: String, dt: String): FutureWeatherDataModel
}