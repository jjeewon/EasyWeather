package com.example.ui.weather

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.presentation.weather.viewmodel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel,
    onWeatherClicked: (String) -> Unit,
){
    val uiState by viewModel.uiState.collectAsState()
    Scaffold { paddingValues ->
        WeatherContent(
            modifier = Modifier
                .padding(paddingValues),
            currentLoc = uiState.currentLoc,
            lastUpdatedTime = uiState.lastUpdatedTime,
            weatherOverViewUiState = uiState.weatherOverViewUiState,
            futureWeatherUiState = uiState.futureWeatherUiState,
            onWeatherClicked = { onWeatherClicked.invoke(
                uiState.lastLng
            ) }
        )
    }

}