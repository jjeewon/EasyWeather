package com.example.ui.weather

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.presentation.weather.model.FutureWeatherUiState
import com.example.ui.theme.dpTextUnit

@Composable
fun ForecastCard(
    modifier: Modifier,
    futureWeatherUiState: FutureWeatherUiState
) {
    AnimatedVisibility(
        visible = futureWeatherUiState is FutureWeatherUiState.Visible,
        enter = fadeIn()
    ) {
        if (futureWeatherUiState !is FutureWeatherUiState.Visible) return@AnimatedVisibility
        Card(
            modifier = Modifier
                .padding(top = 30.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
        ) {
            Column(
                modifier = Modifier.background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(5.dp)
                )
            ) {
                Text(
                    "forecast",
                    modifier = Modifier
                        .padding(end = 6.dp, top = 6.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.dpTextUnit
                )
                FutureWeatherCardList(
                    modifier = modifier,
                    futureWeatherList = futureWeatherUiState.futureWeatherList,
                )
            }
        }
    }

}