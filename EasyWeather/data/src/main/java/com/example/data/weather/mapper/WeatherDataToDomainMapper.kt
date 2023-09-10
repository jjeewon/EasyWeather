package com.example.data.weather.mapper

import com.example.data.weather.model.WeatherDataModel
import com.example.domains.weather.model.WeatherDomainModel

class WeatherDataToDomainMapper {
    fun toDomain(input: WeatherDataModel) = WeatherDomainModel(
        lastUpdated = input.lastUpdated,
        name = input.name,
        region = input.region,
        tempC = input.tempC,
        tempF = input.tempF,
        humidity = input.humidity,
        condition = input.condition,
        conditionIcon = "https:${input.conditionIcon}",
        windMph = input.windMph,
        windKph = input.windKph,
        windDegree = input.windDegree,
        windDir = input.windDir,
        pressureMb = input.pressureMb,
        pressureIn = input.pressureIn,
        cloud = input.cloud,
        visKm = input.visKm,
        visMiles = input.visMiles,
        uv = input.uv,
        gustKph = input.gustKph,
        gustMph = input.gustMph
    )
}