package com.example.presentation.weather.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.domains.weather.usecase.GetFutureWeatherUseCase
import com.example.domains.weather.usecase.GetWeatherUseCase
import com.example.presentation.architecture.viewmodel.BaseViewModel
import com.example.presentation.weather.mapper.FutureWeatherDomainToPresentationMapper
import com.example.presentation.weather.mapper.WeatherDomainToPresentationMapper
import com.example.presentation.weather.model.FutureWeatherUiState
import com.example.presentation.weather.model.WeatherOverViewUiState
import com.example.presentation.weather.model.WeatherUiState
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
    private val getFutureWeatherUseCase: GetFutureWeatherUseCase,
    private val weatherDomainToPresentationMapper: WeatherDomainToPresentationMapper,
    private val futureWeatherDomainToPresentationMapper: FutureWeatherDomainToPresentationMapper,
    useCaseExecutor: UseCaseExecutor,
): BaseViewModel<WeatherUiState>(useCaseExecutor) {

    private var currentLatLng: Pair<Double, Double> = 0.0 to 0.0
    override fun initialState(): WeatherUiState = WeatherUiState()

    fun onEntered() {
        updateUiState(WeatherUiState::loading)
    }

    fun getWeatherFromLocation(lat: Double, lng: Double) {
        viewModelScope.launch {
            val (currentLat, currentLng) = currentLatLng
            if (currentLat == lat && currentLng == lng) return@launch
            currentLatLng = lat to lng
            getCurrentWeather(lat, lng)
            getFutureWeather(lat, lng)
        }
    }

    private fun getCurrentWeather(lat: Double, lng: Double) {
        viewModelScope.launch {
            val resultWeather = weatherDomainToPresentationMapper.toPresentation(getWeatherUseCase.executeInBackground(GetWeatherUseCase.Param.LatLng(
                lat = lat,
                lng = lng,
            )))

            val weatherOverViewUiState = WeatherOverViewUiState.Visible(
                region = resultWeather.region,
                temp = resultWeather.tempC.toString(),
                humidity = resultWeather.humidity.toString(),
                condition = resultWeather.condition,
                conditionIcon = resultWeather.conditionIcon
            )
            updateUiState {
                this.copy(
                    isLoading = false,
                    currentLoc = resultWeather.name,
                    lastUpdatedTime = resultWeather.lastUpdated,
                    weatherOverViewUiState = weatherOverViewUiState,
                    lastLng = "${lat}_${lng}"
                )
            }
        }
    }

    private fun getFutureWeather(lat: Double, lng: Double) {
        viewModelScope.launch {
            val currentDate = LocalDate.now().plusDays(15)
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val datList = (1..6).map { currentDate.plusDays(it.toLong()).format(formatter) }
            val result = futureWeatherDomainToPresentationMapper.toPresentation(getFutureWeatherUseCase.executeInBackground(GetFutureWeatherUseCase.Param(
                datList = datList,
                location = GetFutureWeatherUseCase.Location.LatLng(
                    lat = lat,
                    lng = lng,
                )
            )))
            updateUiState {
                this.copy(
                    isLoading = false,
                    futureWeatherUiState = FutureWeatherUiState.Visible(
                        futureWeatherList = result
                    )
                )
            }
        }
    }
}