package com.example.easyweather.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.presentation.weather.model.WeatherDetailUiState

@Composable
fun WeatherDetailCard(
    modifier: Modifier,
    uiState: WeatherDetailUiState,
){
    if (uiState !is WeatherDetailUiState.Visible) return
    Column(
        modifier = modifier,
    ) {
        Text(uiState.name)
        Text(uiState.region)
        Text(uiState.temp)
        Text(uiState.humidity)
        Text(uiState.condition)
        LoadImageFromUrl(uiState.conditionIcon)
    }
}

@Composable
fun LoadImageFromUrl(url: String) {
    val painter = rememberAsyncImagePainter(ImageRequest.Builder
            (LocalContext.current).data(data = url).apply<ImageRequest.Builder>(block = fun ImageRequest.Builder.() {
        }).build()
        )

    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}