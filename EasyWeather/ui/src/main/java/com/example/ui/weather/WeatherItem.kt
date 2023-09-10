package com.example.ui.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WeatherItem(
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