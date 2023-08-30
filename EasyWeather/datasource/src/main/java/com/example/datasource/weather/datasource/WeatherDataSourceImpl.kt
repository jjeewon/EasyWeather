package com.example.datasource.weather.datasource

import com.example.data.weather.datasource.WeatherDataSource
import com.example.data.weather.model.WeatherDataModel
import com.example.datasource.WeatherApi
import com.example.datasource.weather.mapper.WeatherToDataMapper

class WeatherDataSourceImpl(
    private val weatherApi: WeatherApi,
    private val weatherToDataMapper: WeatherToDataMapper
): WeatherDataSource {
    override suspend fun getWeather(q: String): WeatherDataModel {
        return weatherToDataMapper.toData(
            weatherApi.getWeather(q)
        )
    }
}