package com.example.data.weather.model

data class WeatherDataModel (
    val lastUpdated: String,
    val name: String,
    val region: String,
    val tempC: Double,
    val tempF: Double,
    val humidity: Int,
    val condition: String,
    val conditionIcon: String,
    val windMph: Double,
    val windKph: Double,
    val windDegree: Int,
    val windDir: String,
    val pressureMb: Double,
    val pressureIn: Double,
    val cloud: Int,
    val visKm: Double,
    val visMiles: Double,
    val uv: Double,
    val gustMph: Double,
    val gustKph: Double
)