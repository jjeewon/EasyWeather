package com.example.ui.weatherdetail


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.presentation.weatherdetail.model.WeatherCardUiState
import com.example.ui.theme.dpTextUnit
import org.w3c.dom.Text

@Composable
fun WeatherDetailCard(
    modifier: Modifier,
    uiState: WeatherCardUiState,
) {
    if (uiState !is WeatherCardUiState.Visible) return
    val textSize = 20.dpTextUnit
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = Color.LightGray,
            )
            .padding(top = 30.dp)
         ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoadImageFromUrl(
            modifier = modifier,
            url = uiState.conditionIcon
        )
        Text(uiState.name, modifier = Modifier
            .padding(vertical = 10.dp)
            .background(color = Color.White, shape = RoundedCornerShape(10.dp))
            .padding(vertical = 2.dp, horizontal = 20.dp), fontSize = 30.dpTextUnit, fontWeight = FontWeight.Bold)
        ConditionCard(uiState.condition, modifier = Modifier.padding(vertical = 5.dp), fontSize = textSize)
        TempCard(uiState.temp, modifier = Modifier.padding(vertical = 5.dp), fontSize = textSize)
        HumidityCard(uiState.humidity, modifier = Modifier.padding(vertical = 5.dp), fontSize = textSize)
        CloudCard(uiState.cloud.toString(), modifier = Modifier.padding(vertical = 5.dp), fontSize = textSize)
        UvCard(uiState.uv.toString(),modifier = Modifier.padding(vertical = 5.dp), fontSize = textSize)
        WindCard(uiState.windDegree.toString(), uiState.windKph.toString(),modifier = Modifier.padding(vertical = 5.dp), fontSize = textSize)
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
            .size(70.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ConditionCard(
    condition: String,
    modifier: Modifier,
    fontSize: TextUnit
) {
    Row(modifier = modifier) {
        Text("condition", modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp)).padding(5.dp), fontSize = fontSize, fontWeight = FontWeight.Bold)
        Text(condition, modifier = modifier.padding(start = 10.dp), fontSize = fontSize)
    }
}

@Composable
fun TempCard(
    temp: String,
    modifier: Modifier,
    fontSize: TextUnit
) {
    Row(modifier = modifier) {
        Text("temp", modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp)).padding(5.dp), fontSize = fontSize, fontWeight = FontWeight.Bold)
        Text(temp, modifier = modifier.padding(start = 10.dp), fontSize = fontSize)
    }
}

@Composable
fun HumidityCard(
    humidity: String,
    modifier: Modifier,
    fontSize: TextUnit
) {
    Row(modifier = modifier) {
        Text("humidity", modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp)).padding(5.dp), fontSize = fontSize, fontWeight = FontWeight.Bold)
        Text(humidity, modifier = modifier.padding(start = 10.dp), fontSize = fontSize)
    }
}

@Composable
fun CloudCard(
    cloud: String,
    modifier: Modifier,
    fontSize: TextUnit
) {
    Row(modifier = modifier) {
        Text("cloud", modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp)).padding(5.dp), fontSize = fontSize, fontWeight = FontWeight.Bold)
        Text(cloud, modifier = modifier.padding(start = 10.dp), fontSize = fontSize)
    }
}

@Composable
fun UvCard(
    uv: String,
    modifier: Modifier,
    fontSize: TextUnit
) {
    Row(modifier = modifier) {
        Text("uv", modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp)).padding(5.dp), fontSize = fontSize, fontWeight = FontWeight.Bold)
        Text(uv, modifier = modifier.padding(start = 10.dp), fontSize = fontSize)
    }
}

@Composable
fun WindCard(
    windDegree: String,
    windKph: String,
    modifier: Modifier,
    fontSize: TextUnit
) {
    Row(modifier = modifier) {
        Text("windDegree", modifier = modifier.background(color = Color.White, shape = RoundedCornerShape(4.dp)).padding(5.dp), fontSize = fontSize, fontWeight = FontWeight.Bold)
        Text(windDegree, modifier = modifier.padding(start = 10.dp), fontSize = fontSize)
        Text("windKph", modifier = modifier.padding(start = 10.dp).background(color = Color.White, shape = RoundedCornerShape(4.dp)).padding(5.dp), fontSize = fontSize, fontWeight = FontWeight.Bold)
        Text(windKph, modifier = modifier.padding(start = 10.dp), fontSize = fontSize)
    }
}

