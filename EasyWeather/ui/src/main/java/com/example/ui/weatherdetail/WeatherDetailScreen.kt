package com.example.ui.weatherdetail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.presentation.weatherdetail.viewmodel.WeatherDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherDetailScreen(
    viewModel: WeatherDetailViewModel,
    latLng: String?,
){
    LaunchedEffect(key1 = latLng) {
        viewModel.getWeatherFromLocation(latLng)
    }
    val uiState by viewModel.uiState.collectAsState()
    Scaffold { paddingValues ->
        WeatherDetailContent(
            modifier = Modifier
                .padding(paddingValues),
            weatherDetailUiState = uiState.weatherCardUiState
        )
    }

}