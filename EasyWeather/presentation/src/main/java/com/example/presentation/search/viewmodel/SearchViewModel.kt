package com.example.presentation.search.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.domains.weather.usecase.GetLocationAutoCompleteUseCase
import com.example.domains.weather.usecase.GetWeatherUseCase
import com.example.presentation.architecture.viewmodel.BaseViewModel
import com.example.presentation.search.mapper.AutoCompleteDomainToPresentationMapper
import com.example.presentation.search.model.AutoCompletePresentationModel
import com.example.presentation.search.model.LocationPresentationModel
import com.example.presentation.search.model.SearchUiState
import com.example.presentation.search.model.SearchWeatherUiState
import com.example.presentation.weather.mapper.WeatherDomainToPresentationMapper
import com.example.presentation.weather.model.WeatherOverViewUiState
import com.example.presentation.weatherdetail.mapper.WeatherDetailToPresentationMapper
import com.example.presentation.weatherdetail.model.WeatherCardUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getLocationAutoCompleteUseCase: GetLocationAutoCompleteUseCase,
    private val autoCompleteDomainToPresentationMapper: AutoCompleteDomainToPresentationMapper,
    private val getWeatherUseCase: GetWeatherUseCase,
    private val weatherDomainToPresentationMapper: WeatherDetailToPresentationMapper,
    useCaseExecutor: UseCaseExecutor,
) : BaseViewModel<SearchUiState>(useCaseExecutor) {
    override fun initialState(): SearchUiState = SearchUiState()

    fun onEntered() {
        updateUiState(SearchUiState::loading)
    }

    fun getLocationByQuery(query: String) {
        viewModelScope.launch {
            if (query.isEmpty()) {
                updateUiState { this.copy(
                    isLoading = true,
                    autoCompleteList = listOf()
                ) }
                return@launch
            }
            getLocationAutoCompleteUseCase.run(
                value = GetLocationAutoCompleteUseCase.Param(
                    query = query,
                )
                ,
                onResult = {
                    val autoCompleteList = autoCompleteDomainToPresentationMapper.toPresentation(it).list
                    updateUiState {
                        this.copy(
                            isLoading = true,
                            autoCompleteList = autoCompleteList
                        )
                    }
                },
                onException = {}
            )
        }
    }

    fun onWeatherItemSelected(model: LocationPresentationModel) {
        getWeatherFromLocation(
            lat = model.lat,
            lng = model.lng,
        )
    }

    private fun getWeatherFromLocation(lat: Double, lng: Double) {
        viewModelScope.launch {
            getWeatherUseCase.run(
                value = GetWeatherUseCase.Param.LatLng(
                    lat = lat,
                    lng = lng,
                ),
                onResult = {
                    val result = weatherDomainToPresentationMapper.toPresentation(it)
                    val weatherCardUiState = SearchWeatherUiState.Visible(
                        region = result.name,
                        temp = result.tempC.toString(),
                        humidity = result.humidity.toString(),
                        condition = result.condition,
                        windKph = result.windKph.toString(),
                        windDegree = result.windDegree.toString(),
                        cloud = result.cloud.toString(),
                        uv = result.uv.toString(),
                    )
                    updateUiState {
                        this.copy(
                            searchWeatherUiState = weatherCardUiState
                        )
                    }
                },
                onException = {}
            )
        }
    }
}