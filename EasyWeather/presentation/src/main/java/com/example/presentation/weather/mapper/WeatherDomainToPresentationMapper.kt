package com.example.presentation.weather.mapper

import com.example.domains.weather.model.WeatherDomainModel
import com.example.presentation.weather.model.WeatherPresentationModel

class WeatherDomainToPresentationMapper {
    fun toPresentation(input: WeatherDomainModel) = WeatherPresentationModel(
        name = input.name,
        region = input.region,
        tempC = input.tempC,
        tempF = input.tempF,
        humidity = input.humidity,
        condition = input.condition,
        conditionIcon = input.conditionIcon
    )
}