package com.example.ui.weatherdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.weatherdetail.model.WeatherCardUiState

@Composable
fun WeatherDetailContent(
    modifier: Modifier = Modifier,
    weatherDetailUiState: WeatherCardUiState,
){
    WeatherDetailCard(
        modifier = modifier,
        uiState = weatherDetailUiState,
    )
}