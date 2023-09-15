package com.example.presentation.search.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.domains.weather.usecase.GetFutureWeatherUseCase
import com.example.domains.weather.usecase.GetLocationAutoCompleteUseCase
import com.example.presentation.architecture.viewmodel.BaseViewModel
import com.example.presentation.search.mapper.AutoCompleteDomainToPresentationMapper
import com.example.presentation.search.model.SearchUiState
import com.example.presentation.weather.model.FutureWeatherUiState
import com.example.presentation.weather.model.WeatherUiState
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class SearchViewModel(
    private val getLocationAutoCompleteUseCase: GetLocationAutoCompleteUseCase,
    private val autoCompleteDomainToPresentationMapper: AutoCompleteDomainToPresentationMapper,
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
                onException = {

                }
            )
        }
    }
}