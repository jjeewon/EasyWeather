package com.example.easyweather.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

interface WeatherDestination {
    val icon: ImageVector
    val route: String
}

object OverView: WeatherDestination {
    override val icon: ImageVector = Icons.Default.Call
    override val route: String = "overview"
}

object Favorite: WeatherDestination {
    override val icon: ImageVector = Icons.Default.Favorite
    override val route: String = "favorite"

}

object SingleWeather: WeatherDestination {
    override val icon: ImageVector = Icons.Default.AccountBox
    override val route: String = "single_weather"

    const val latLngArg = "lat_lng"
    val routhWihArgs = "$route/$latLngArg"
    val arguments = listOf(
        navArgument(latLngArg) { type = NavType.StringType }
    )
    val deepLinks = listOf(
        navDeepLink { uriPattern = "weather://$routhWihArgs/{$latLngArg}" }
    )

}

val weatherTabRowScreens = listOf(OverView, Favorite)