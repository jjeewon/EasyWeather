package com.example.domains.weather.model

data class WeatherDomainModel(
    val name: String,
    val region: String,
    val tempC: Double,
    val tempF: Double,
    val humidity: Int,
    val condition: String,
    val conditionIcon: String,
)