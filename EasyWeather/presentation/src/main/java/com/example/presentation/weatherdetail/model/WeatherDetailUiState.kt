package com.example.presentation.weatherdetail.model

data class WeatherDetailUiState (
    val isLoading: Boolean = false,
    val weatherCardUiState: WeatherCardUiState = WeatherCardUiState.Invisible,
    val latLng: String = "",
) {
    fun loading() = copy(isLoading = true)
}

sealed interface WeatherCardUiState{
    object Invisible: WeatherCardUiState
    data class Visible(
        val name: String,
        val region: String,
        val temp: String,
        val humidity: String,
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
    ): WeatherCardUiState
}