package com.example.presentation.weather.viewmodel

import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.presentation.architecture.viewmodel.BaseViewModel
import com.example.presentation.weather.model.WeatherUiState

class WeatherViewModel(
    useCaseExecutor: UseCaseExecutor,
): BaseViewModel<WeatherUiState>(useCaseExecutor) {
    override fun initialState(): WeatherUiState = WeatherUiState()

    fun onEntered(phoneId: String) {
        updateUiState(WeatherUiState::loading)
        fetchWeatherDetail()
    }

    private fun fetchWeatherDetail() {
    }
}