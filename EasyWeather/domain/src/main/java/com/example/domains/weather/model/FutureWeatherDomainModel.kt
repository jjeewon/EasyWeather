package com.example.domains.weather.model

data class FutureWeatherDomainModel(
    val date: String,
    val maxTempC: Double,
    val maxTempF: Double,
    val minTempC: Double,
    val minTempF: Double,
    val avgTempC: Double,
    val avgTempF: Double,
    val maxWindMph: Double,
    val maxWindKph: Double,
    val avgHumidity: Double,
    val condition: String,
    val hourList: List<HourDomainModel>
)

data class HourDomainModel(
    val timeEpoch: Long,
    val time: String,
    val tempC: Double,
    val tempF: Double,
    val condition: String,
    val conditionIcon: String,
    val windMph: Double,
    val windKph: Double,
    val windDegree: Int,
    val windDir: String,
    val humidity: Int,
    val cloud: Int,
    val willItRain: Int,
    val chanceOfRain: Int,
    val willItSnow: Int,
    val chanceOfSnow: Int,
)