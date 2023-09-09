package com.example.ui.weather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.weather.model.WeatherOverViewUiState

@Composable
fun WeatherContent(
    modifier: Modifier = Modifier,
    weatherOverViewUiState: WeatherOverViewUiState,
    onWeatherClicked: () -> Unit
){
    WeatherCard(
        modifier = modifier,
        uiState = weatherOverViewUiState,
        onWeatherClicked = onWeatherClicked,
    )
}