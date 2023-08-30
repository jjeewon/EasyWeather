package com.example.presentation.weather.model

data class WeatherPresentationModel(
    val name: String,
    val region: String,
    val tempC: Double,
    val tempF: Double,
    val humidity: Int,
    val condition: String,
    val conditionIcon: String,
)
