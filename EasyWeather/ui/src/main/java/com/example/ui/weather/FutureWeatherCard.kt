package com.example.ui.weather

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.presentation.weather.model.FutureWeatherPresentationModel

@Composable
fun FutureWeatherCard(
    modifier: Modifier,
    item: FutureWeatherPresentationModel,
) {
    Card(
        modifier = modifier.padding(start = 12.dp, top = 8.dp, end = 15.dp, bottom = 12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, Color.Gray),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                item.date,
                modifier = Modifier
                    .background(color = Color.Transparent, shape = RoundedCornerShape(5.dp))
                    .padding(vertical = 2.dp, horizontal = 5.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            FutureWeatherCardItem(
                title = "average temp",
                desc = item.avgTempC.toString(),
                unit = "°C"
            )
            FutureWeatherCardItem(
                title = "minimum temp",
                desc = item.minTempC.toString(),
                unit = "°C"
            )
            FutureWeatherCardItem(
                title = "maximum temp",
                desc = item.maxTempC.toString(),
                unit = "°C"
            )
            FutureWeatherCardItem(
                title = "average humidity",
                desc = item.avgHumidity.toString(),
                unit = "%"
            )
        }
    }
}

@Composable
fun FutureWeatherCardItem(
    title: String,
    desc: String,
    unit: String,
) {
    Row(
        modifier = Modifier.padding(vertical = 2.dp)
    ) {
        Text(
            modifier = Modifier
                .background(color = Color.LightGray, shape = RoundedCornerShape(6.dp))
                .padding(6.dp),
            text = title,
            fontWeight = FontWeight.W500,
            fontFamily = FontFamily.Serif,
        )
        Text(
            modifier = Modifier.padding(start = 10.dp, top = 6.dp, bottom = 6.dp),
            text = desc,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = unit,
            modifier = Modifier
                .padding(vertical = 6.dp),
        )
    }
}