package com.example.presentation.weather.model

sealed interface WeatherOverViewUiState{
    object Invisible: WeatherOverViewUiState
    data class Visible(
        val region: String,
        val temp: String,
        val humidity: String,
        val condition: String,
        val conditionIcon: String,
    ): WeatherOverViewUiState
}