package com.example.presentation.weather.model

data class WeatherUiState (
    val isLoading: Boolean = false,
    val weatherDetailUiState: WeatherDetailUiState = WeatherDetailUiState.Invisible
) {
    fun loading() = copy(isLoading = true)
}

sealed interface WeatherDetailUiState{
    object Invisible: WeatherDetailUiState
    data class Visible(
        val name: String,
        val region: String,
        val temp: String,
        val humidity: String,
        val condition: String,
        val conditionIcon: String,
    ): WeatherDetailUiState
}