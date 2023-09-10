package com.example.ui.weather

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.weather.model.FutureWeatherUiState
import com.example.presentation.weather.model.WeatherOverViewUiState

@Composable
fun WeatherContent(
    modifier: Modifier = Modifier,
    currentLoc: String,
    lastUpdatedTime: String,
    weatherOverViewUiState: WeatherOverViewUiState,
    futureWeatherUiState: FutureWeatherUiState,
    onWeatherClicked: () -> Unit
) {
    Column(modifier.padding(vertical = 20.dp, horizontal = 12.dp)) {
        CurrentWeatherCard(
            modifier = modifier,
            currentLoc = currentLoc,
            lastUpdatedTime = lastUpdatedTime,
            weatherOverViewUiState = weatherOverViewUiState,
            onWeatherClicked = onWeatherClicked,
        )
        ForecastCard(modifier = modifier, futureWeatherUiState = futureWeatherUiState)
    }
}