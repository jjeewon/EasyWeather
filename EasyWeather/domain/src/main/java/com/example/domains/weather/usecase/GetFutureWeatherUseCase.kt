package com.example.domains.weather.usecase

import com.example.domains.architecture.coroutine.CoroutineContextProvider
import com.example.domains.architecture.usecase.BackgroundExecutingUseCase
import com.example.domains.weather.model.FutureWeatherDomainModel
import com.example.domains.weather.repository.WeatherRepository

class GetFutureWeatherUseCase(
    coroutineContextProvider: CoroutineContextProvider,
    private val weatherRepository: WeatherRepository,
): BackgroundExecutingUseCase<GetFutureWeatherUseCase.Param, List<FutureWeatherDomainModel>>(
    coroutineContextProvider
) {
    override suspend fun executeInBackground(request: Param): List<FutureWeatherDomainModel> {
        val q = when (val location = request.location) {
            is Location.City -> {
                location.name
            }
            is Location.LatLng -> {
                "${location.lat},${location.lng}"
            }
        }
        val datList = request.datList
        val result = datList.map { weatherRepository.getFutureWeather(q, it) }
        return result
    }

    data class Param(
        val datList: List<String>,
        val location: Location
    )

    sealed interface Location {
        data class LatLng(
            val lat: Double,
            val lng: Double,
        ): Location

        data class City(
            val name: String,
        ): Location
    }
}