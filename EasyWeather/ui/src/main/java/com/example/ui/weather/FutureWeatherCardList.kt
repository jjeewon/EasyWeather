package com.example.ui.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.presentation.weather.model.FutureWeatherPresentationModel

@Composable
fun FutureWeatherCardList (
    modifier: Modifier,
    futureWeatherList: List<FutureWeatherPresentationModel>,
){
    val listState = rememberLazyListState()
    LazyRow(
        modifier = modifier.background(color = Color.Transparent, shape = RoundedCornerShape(20.dp)),
        state = listState,
    ){
        items(futureWeatherList){ item ->
            FutureWeatherCard(modifier = modifier.background(color = Color.Transparent), item = item)
        }
    }
}