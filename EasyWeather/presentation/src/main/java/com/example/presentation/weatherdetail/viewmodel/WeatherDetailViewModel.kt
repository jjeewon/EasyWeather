package com.example.presentation.weatherdetail.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.domains.weather.usecase.GetWeatherUseCase
import com.example.presentation.architecture.viewmodel.BaseViewModel
import com.example.presentation.weatherdetail.mapper.WeatherDetailToPresentationMapper
import com.example.presentation.weatherdetail.model.WeatherCardUiState
import com.example.presentation.weatherdetail.model.WeatherDetailUiState
import kotlinx.coroutines.launch

class WeatherDetailViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherDomainToPresentationMapper: WeatherDetailToPresentationMapper,
    useCaseExecutor: UseCaseExecutor,
): BaseViewModel<WeatherDetailUiState>(useCaseExecutor) {
    override fun initialState(): WeatherDetailUiState = WeatherDetailUiState()

    fun onEntered() {
        updateUiState(WeatherDetailUiState::loading)
    }

    fun getWeatherFromLocation(latLng: String?) {
        viewModelScope.launch {
            val (lat, lng) = latLng?.split('_')?.map { it.toDoubleOrNull() } ?: return@launch
            lat ?: return@launch
            lng ?: return@launch
            val result = weatherDomainToPresentationMapper.toPresentation(getWeatherUseCase.executeInBackground(
                GetWeatherUseCase.Param.LatLng(
                lat = lat,
                lng = lng,
            )))
            val weatherCardUiState = WeatherCardUiState.Visible(
                name = result.name,
                region = result.region,
                temp = result.tempC.toString(),
                humidity = result.humidity.toString(),
                condition = result.condition,
                conditionIcon = result.conditionIcon,
                windMph = result.windMph,
                windKph = result.windKph,
                windDegree = result.windDegree,
                windDir = result.windDir,
                pressureMb = result.pressureMb,
                pressureIn = result.pressureIn,
                cloud = result.cloud,
                visKm = result.visKm,
                visMiles = result.visMiles,
                uv = result.uv,
                gustKph = result.gustKph,
                gustMph = result.gustMph
            )
            updateUiState {
                this.copy(
                    isLoading = false,
                    weatherCardUiState = weatherCardUiState
                )
            }
        }
    }
}