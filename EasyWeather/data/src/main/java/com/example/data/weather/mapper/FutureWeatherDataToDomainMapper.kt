package com.example.data.weather.mapper

import com.example.data.weather.model.FutureWeatherDataModel
import com.example.domains.weather.model.FutureWeatherDomainModel
import com.example.domains.weather.model.HourDomainModel

class FutureWeatherDataToDomainMapper {
    fun toDomain(input: FutureWeatherDataModel): FutureWeatherDomainModel {
        val hourList = input.hourList.map {
            HourDomainModel(
                timeEpoch = it.time_epoch,
                time = it.time,
                tempC = it.temp_c,
                tempF = it.temp_f,
                condition = it.condition,
                conditionIcon = "https:${it.conditionIcon}",
                windMph = it.wind_mph,
                windKph = it.wind_mph,
                windDegree = it.wind_degree,
                windDir = it.wind_dir,
                humidity = it.humidity,
                cloud = it.cloud,
                willItRain = it.will_it_rain,
                chanceOfRain = it.chance_of_rain,
                chanceOfSnow = it.chance_of_snow,
                willItSnow = it.will_it_snow,
            )
        }
        return FutureWeatherDomainModel(
            date = input.date,
            maxTempC = input.maxtemp_c,
            maxTempF = input.maxtemp_f,
            minTempC = input.mintemp_c,
            minTempF = input.mintemp_f,
            avgTempC = input.avgtemp_c,
            avgTempF = input.avgtemp_f,
            condition = input.condition,
            maxWindKph = input.maxwind_kph,
            maxWindMph = input.maxwind_mph,
            avgHumidity = input.avghumidity,
            hourList = hourList,
        )
    }
}