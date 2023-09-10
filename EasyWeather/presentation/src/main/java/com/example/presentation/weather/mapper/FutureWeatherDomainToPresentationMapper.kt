package com.example.presentation.weather.mapper

import com.example.domains.weather.model.FutureWeatherDomainModel
import com.example.presentation.weather.model.FutureWeatherPresentationModel
import com.example.presentation.weather.model.HourPresentationModel

class FutureWeatherDomainToPresentationMapper {
    fun toPresentation(input: List<FutureWeatherDomainModel>): List<FutureWeatherPresentationModel> {
        val result = input.map { model ->
            val hourList = model.hourList.map {
                HourPresentationModel(
                    timeEpoch = it.timeEpoch,
                    time = it.time,
                    tempC = it.tempC,
                    tempF = it.tempF,
                    condition = it.condition,
                    conditionIcon = it.conditionIcon,
                    windMph = it.windMph,
                    windKph = it.windKph,
                    windDegree = it.windDegree,
                    windDir = it.windDir,
                    humidity = it.humidity,
                    cloud = it.cloud,
                    willItRain = it.willItRain,
                    chanceOfRain = it.chanceOfRain,
                    chanceOfSnow = it.chanceOfSnow,
                    willItSnow = it.willItSnow,
                )
            }
            FutureWeatherPresentationModel(
                date = model.date,
                maxTempC = model.maxTempC,
                maxTempF = model.maxTempF,
                minTempC = model.minTempC,
                minTempF = model.minTempF,
                avgTempC = model.avgTempC,
                avgTempF = model.avgTempF,
                condition = model.condition,
                maxWindKph = model.maxWindKph,
                maxWindMph = model.maxWindMph,
                avgHumidity = model.avgHumidity,
                hourList = hourList,
            )
        }
        return result
    }
}