package com.example.domains.weather.usecase

import com.example.domains.architecture.coroutine.CoroutineContextProvider
import com.example.domains.architecture.usecase.BackgroundExecutingUseCase
import com.example.domains.weather.model.LocationAutoCompleteDomainModel
import com.example.domains.weather.repository.WeatherRepository

class GetLocationAutoCompleteUseCase(
    coroutineContextProvider: CoroutineContextProvider,
    private val weatherRepository: WeatherRepository,
): BackgroundExecutingUseCase<GetLocationAutoCompleteUseCase.Param, LocationAutoCompleteDomainModel>(
    coroutineContextProvider
) {
    override suspend fun executeInBackground(request: Param): LocationAutoCompleteDomainModel {
        val query = request.query
        return weatherRepository.getLocationAutoComplete(query)
    }

    data class Param(
        val query: String,
    )
}