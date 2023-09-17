package com.example.ui.search

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ui.theme.dpTextUnit

@Composable
fun WeatherItemCard(
    modifier: Modifier,
    label: String,
    value: String,
){
    Row(modifier = modifier) {
        Text(
            modifier = modifier.weight(0.5f).padding(end = 5.dp),
            text =  label,
            textAlign = TextAlign.End,
            fontSize = 26.dpTextUnit,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = modifier.weight(0.5f).padding(start = 5.dp),
            text =  value,
            textAlign = TextAlign.Start,
            fontSize = 20.dpTextUnit,
        )
    }
}