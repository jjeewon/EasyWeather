package com.example.presentation.weather.model

data class WeatherUiState (
    val isLoading: Boolean = false,
    val currentLoc: String = "",
    val lastUpdatedTime: String = "",
    val weatherOverViewUiState: WeatherOverViewUiState = WeatherOverViewUiState.Invisible,
    val futureWeatherUiState: FutureWeatherUiState = FutureWeatherUiState.Invisible,
    val lastLng: String = "",
) {
    fun loading() = copy(isLoading = true)
}