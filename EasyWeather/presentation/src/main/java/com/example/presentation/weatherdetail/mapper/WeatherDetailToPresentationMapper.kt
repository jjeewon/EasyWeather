package com.example.presentation.weatherdetail.mapper

import com.example.domains.weather.model.WeatherDomainModel
import com.example.presentation.weatherdetail.model.WeatherDetailPresentationModel

class WeatherDetailToPresentationMapper {
    fun toPresentation(input: WeatherDomainModel) = WeatherDetailPresentationModel(
        name = input.name,
        region = input.region,
        tempC = input.tempC,
        tempF = input.tempF,
        humidity = input.humidity,
        condition = input.condition,
        conditionIcon = input.conditionIcon,
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