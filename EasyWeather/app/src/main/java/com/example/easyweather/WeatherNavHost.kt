package com.example.easyweather

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun WeatherNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = OverView.route,
        modifier = modifier,
    ) {
        composable(route = OverView.route) {
            // screen
        }
        composable(route = Favorite.route) {
            // screen
        }
        composable(
            route = SingleWeather.routhWihArgs,
            arguments = SingleWeather.arguments,
            deepLinks = SingleWeather.deepLinks
        ) { navBackStackEntry ->
            val latLng = navBackStackEntry.arguments?.getString(SingleWeather.latLngArg)
            // SingleWeatherScreen(latLng)
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }

fun NavHostController.navigateToSingleWeather(latLng: String) {
    this.navigateSingleTopTo("${SingleWeather.route}/$latLng")
}