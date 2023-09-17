package com.example.ui.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.presentation.search.model.SearchWeatherUiState

@Composable
fun WeatherItemList(
    modifier: Modifier,
    searchWeatherUiState: SearchWeatherUiState,
) {
    AnimatedVisibility(
        visible =  searchWeatherUiState is SearchWeatherUiState.Visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        if (searchWeatherUiState !is SearchWeatherUiState.Visible) return@AnimatedVisibility
        Card(
            modifier = modifier,
            elevation = CardDefaults.cardElevation(),
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray
            )
        ) {
            Column() {
                WeatherItemCard(
                    modifier = Modifier,
                    label = "region",
                    value = searchWeatherUiState.region
                )
                WeatherItemCard(
                    modifier = Modifier,
                    label = "condition",
                    value = searchWeatherUiState.condition
                )
                WeatherItemCard(
                    modifier = Modifier,
                    label = "temperature",
                    value = searchWeatherUiState.temp
                )
                WeatherItemCard(
                    modifier = Modifier,
                    label = "humidity",
                    value = searchWeatherUiState.humidity
                )
                WeatherItemCard(
                    modifier = Modifier,
                    label = "cloud",
                    value = searchWeatherUiState.cloud
                )
                WeatherItemCard(
                    modifier = Modifier,
                    label = "uv",
                    value = searchWeatherUiState.uv
                )
            }
        }
    }
}