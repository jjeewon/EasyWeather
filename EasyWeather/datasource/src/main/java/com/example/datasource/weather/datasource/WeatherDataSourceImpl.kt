package com.example.datasource.weather.datasource

import com.example.data.weather.datasource.WeatherDataSource
import com.example.data.weather.model.FutureWeatherDataModel
import com.example.data.weather.model.LocationAutoCompleteDataModel
import com.example.data.weather.model.WeatherDataModel
import com.example.datasource.WeatherApi
import com.example.datasource.weather.mapper.FutureWeatherToDataMapper
import com.example.datasource.weather.mapper.LocationAutoCompleteToDataMapper
import com.example.datasource.weather.mapper.WeatherToDataMapper

class WeatherDataSourceImpl(
    private val weatherApi: WeatherApi,
    private val weatherToDataMapper: WeatherToDataMapper,
    private val futureWeatherToDataMapper: FutureWeatherToDataMapper,
    private val locationAutoCompleteToDataMapper: LocationAutoCompleteToDataMapper
): WeatherDataSource {
    override suspend fun getWeather(q: String): WeatherDataModel {
        return weatherToDataMapper.toData(
            weatherApi.getCurrentWeather(q)
        )
    }

    override suspend fun getFutureWeather(q: String, dt: String): FutureWeatherDataModel {
        return futureWeatherToDataMapper.toData(
            weatherApi.getFutureWeather(q, dt)
        )
    }

    override suspend fun getAutoCompleteLocation(q: String): LocationAutoCompleteDataModel {
        return locationAutoCompleteToDataMapper.toData(
            weatherApi.getAutoCompleteResult(q)
        )
    }
}