package com.example.presentation.search.model

data class SearchUiState (
    val isLoading: Boolean = false,
    val autoCompleteList: List<LocationPresentationModel> = listOf(),
    val searchWeatherUiState: SearchWeatherUiState = SearchWeatherUiState.Invisible,
) {
    fun loading() = copy(isLoading = true)
}