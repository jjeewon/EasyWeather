package com.example.ui.weather

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.weather.model.WeatherOverViewUiState
import com.example.ui.theme.dpTextUnit

@Composable
fun CurrentWeatherCard (
    modifier : Modifier,
    currentLoc: String,
    lastUpdatedTime: String,
    weatherOverViewUiState: WeatherOverViewUiState,
    onWeatherClicked: () -> Unit
) {
    AnimatedVisibility(
        visible = weatherOverViewUiState is WeatherOverViewUiState.Visible,
        enter = fadeIn()
    ) {
        if (weatherOverViewUiState !is WeatherOverViewUiState.Visible) return@AnimatedVisibility
        Column(
        ) {
            Text("current location : $currentLoc", fontSize = 17.dpTextUnit)
            Text("last updated time : $lastUpdatedTime", fontSize = 15.dpTextUnit)
            WeatherCard(
                modifier = modifier,
                uiState = weatherOverViewUiState,
                onWeatherClicked = onWeatherClicked,
            )
        }
    }
}