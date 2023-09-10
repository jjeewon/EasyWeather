package com.example.presentation.weather.model

sealed interface FutureWeatherUiState{
    object Invisible: FutureWeatherUiState
    data class Visible(
        val futureWeatherList: List<FutureWeatherPresentationModel>,
    ): FutureWeatherUiState
}
