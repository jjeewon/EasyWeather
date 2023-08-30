package com.example.presentation.weather.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.domains.weather.usecase.GetWeatherUseCase
import com.example.presentation.architecture.viewmodel.BaseViewModel
import com.example.presentation.weather.mapper.WeatherDomainToPresentationMapper
import com.example.presentation.weather.model.WeatherDetailUiState
import com.example.presentation.weather.model.WeatherUiState
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherDomainToPresentationMapper: WeatherDomainToPresentationMapper,
    useCaseExecutor: UseCaseExecutor,
): BaseViewModel<WeatherUiState>(useCaseExecutor) {
    override fun initialState(): WeatherUiState = WeatherUiState()

    fun onEntered() {
        updateUiState(WeatherUiState::loading)
    }

    fun getWeatherFromLocation(lat: Double, lng: Double) {
        viewModelScope.launch {
            getWeatherUseCase.run(
                value = GetWeatherUseCase.Param.LatLng(
                    lat = lat,
                    lng = lng,
                ),
                onResult = {
                    val result = weatherDomainToPresentationMapper.toPresentation(it)
                    val weatherDetailUiState = WeatherDetailUiState.Visible(
                        name = result.name,
                        region = result.region,
                        temp = result.tempC.toString(),
                        humidity = result.humidity.toString(),
                        condition = result.condition,
                        conditionIcon = result.conditionIcon
                    )
                    updateUiState {
                        this.copy(
                            isLoading = false,
                            weatherDetailUiState = weatherDetailUiState
                        )
                    }
                },
                onException = {}
            )
        }
    }
}