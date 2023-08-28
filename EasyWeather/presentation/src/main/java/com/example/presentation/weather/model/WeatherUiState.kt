package com.example.presentation.weather.model

data class WeatherUiState (
    val isLoading: Boolean = false,
) {
    fun loading() = copy(isLoading = true)
}