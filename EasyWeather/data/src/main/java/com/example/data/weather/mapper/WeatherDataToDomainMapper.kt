package com.example.data.weather.mapper

import com.example.data.weather.model.WeatherDataModel
import com.example.domains.weather.model.WeatherDomainModel

class WeatherDataToDomainMapper {
    fun toDomain(input: WeatherDataModel) = WeatherDomainModel(
        name = input.name,
        region = input.region,
        tempC = input.tempC,
        tempF = input.tempF,
        humidity = input.humidity,
        condition = input.condition,
        conditionIcon = "https:${input.conditionIcon}"
    )
}