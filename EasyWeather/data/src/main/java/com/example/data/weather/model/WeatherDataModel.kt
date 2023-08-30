package com.example.data.weather.model

data class WeatherDataModel (
    val name: String,
    val region: String,
    val tempC: Double,
    val tempF: Double,
    val humidity: Int,
    val condition: String,
    val conditionIcon: String,
)