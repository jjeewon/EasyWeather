package com.example.presentation.weather.model

data class WeatherUiState (
    val isLoading: Boolean = false,
    val weatherOverViewUiState: WeatherOverViewUiState = WeatherOverViewUiState.Invisible,
    val lastLng: String = "",
) {
    fun loading() = copy(isLoading = true)
}

sealed interface WeatherOverViewUiState{
    object Invisible: WeatherOverViewUiState
    data class Visible(
        val name: String,
        val region: String,
        val temp: String,
        val humidity: String,
        val condition: String,
        val conditionIcon: String,
    ): WeatherOverViewUiState
}