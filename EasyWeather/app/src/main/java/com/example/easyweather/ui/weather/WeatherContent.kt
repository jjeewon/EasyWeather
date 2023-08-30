package com.example.easyweather.ui.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.weather.model.WeatherDetailUiState

@Composable
fun WeatherContent(
    modifier: Modifier = Modifier,
    weatherDetailUiState: WeatherDetailUiState,
){
    WeatherDetailCard(
        modifier = modifier,
        uiState = weatherDetailUiState
    )
}