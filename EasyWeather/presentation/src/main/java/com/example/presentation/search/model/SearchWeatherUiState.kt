package com.example.presentation.search.model

sealed interface SearchWeatherUiState {
    object Invisible: SearchWeatherUiState

    data class Visible(
        val region: String,
        val condition: String,
        val temp: String,
        val humidity: String,
        val cloud: String,
        val uv: String,
        val windDegree: String,
        val windKph: String,
    ): SearchWeatherUiState
}