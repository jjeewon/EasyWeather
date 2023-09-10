package com.example.ui.weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.presentation.weather.model.WeatherOverViewUiState

@Composable
fun WeatherCard(
    modifier: Modifier,
    uiState: WeatherOverViewUiState.Visible,
    onWeatherClicked: () -> Unit
) {
    Card(
        modifier = modifier.padding(top = 30.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(
            modifier = modifier
                .background(
                    color = Color.Gray,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(10.dp)
                .clickable { onWeatherClicked.invoke() },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoadImageFromUrl(
                modifier = modifier,
                url = uiState.conditionIcon
            )
            Text(uiState.region)
            Text(uiState.temp)
            Text(uiState.humidity)
            Text(uiState.condition)
        }
    }

}

@Composable
fun LoadImageFromUrl(
    modifier: Modifier,
    url: String
) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder
            (LocalContext.current).data(data = url).build()
    )
    Image(
        painter = painter,
        contentDescription = null,
        modifier = modifier
            .background(
                color = Color.White,
                shape = CircleShape
            )
            .padding(10.dp)
            .wrapContentSize(),
        contentScale = ContentScale.Crop
    )
}