package com.example.easyweather.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink

interface WeatherDestination {
    val icon: ImageVector
    val route: String
}

object OverView: WeatherDestination {
    override val icon: ImageVector = Icons.Default.Face
    override val route: String = "overview"
}

object Search: WeatherDestination {
    override val icon: ImageVector = Icons.Default.Search
    override val route: String = "search"
}

object Favorite: WeatherDestination {
    override val icon: ImageVector = Icons.Default.Favorite
    override val route: String = "favorite"

}

object SingleWeather: WeatherDestination {
    override val icon: ImageVector = Icons.Default.AccountBox
    override val route: String = "single_weather"

    const val latLngArg = "lat_lng"
    val routeWithArgs = "$route/{$latLngArg}"
    val arguments = listOf(
        navArgument(latLngArg) {
            type = NavType.StringType
            nullable = true
        }
    )
    val deepLinks = listOf(
        navDeepLink { uriPattern = "weather://$route/{$latLngArg}" }
    )
}

val weatherTabRowScreens = listOf(OverView, Search, Favorite)