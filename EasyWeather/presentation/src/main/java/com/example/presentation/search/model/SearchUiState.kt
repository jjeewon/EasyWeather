package com.example.presentation.search.model

data class SearchUiState (
    val isLoading: Boolean = false,
    val autoCompleteList: List<LocationPresentationModel> = listOf()
) {
    fun loading() = copy(isLoading = true)
}