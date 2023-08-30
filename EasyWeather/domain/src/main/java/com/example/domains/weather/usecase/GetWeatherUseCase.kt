package com.example.domains.weather.usecase

import com.example.domains.architecture.coroutine.CoroutineContextProvider
import com.example.domains.architecture.usecase.BackgroundExecutingUseCase
import com.example.domains.weather.model.WeatherDomainModel
import com.example.domains.weather.repository.WeatherRepository

class GetWeatherUseCase(
    coroutineContextProvider: CoroutineContextProvider,
    private val weatherRepository: WeatherRepository,
): BackgroundExecutingUseCase<GetWeatherUseCase.Param, WeatherDomainModel>(
    coroutineContextProvider
) {
    override suspend fun executeInBackground(request: Param): WeatherDomainModel {
        val q = when (request) {
            is Param.City -> {
                request.name
            }
            is Param.LatLng -> {
                "${request.lat},${request.lng}"
            }
        }
        return weatherRepository.getWeather(q)
    }

    sealed interface Param {
        data class LatLng(
            val lat: Double,
            val lng: Double,
        ): Param

        data class City(
            val name: String,
        ): Param
    }
}