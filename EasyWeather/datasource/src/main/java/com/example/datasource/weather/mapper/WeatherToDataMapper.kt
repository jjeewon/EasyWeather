package com.example.datasource.weather.mapper

import com.example.data.weather.model.WeatherDataModel
import com.example.datasource.weather.model.WeatherApiResponse

class WeatherToDataMapper {
    fun toData(res: WeatherApiResponse) = WeatherDataModel(
        name = res.location.name,
        region = res.location.region,
        tempC = res.current.tempC,
        tempF = res.current.tempF,
        humidity = res.current.humidity,
        condition = res.current.condition.text,
        conditionIcon = res.current.condition.icon,
        windMph = res.current.windMph,
        windKph = res.current.windKph,
        windDegree = res.current.windDegree,
        windDir = res.current.windDir,
        pressureMb = res.current.pressureMb,
        pressureIn = res.current.pressureIn,
        cloud = res.current.cloud,
        visKm = res.current.visKm,
        visMiles = res.current.visMiles,
        uv = res.current.uv,
        gustKph = res.current.gustKph,
        gustMph = res.current.gustMph
    )
}
