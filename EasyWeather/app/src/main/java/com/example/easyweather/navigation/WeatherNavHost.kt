package com.example.easyweather.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.presentation.weather.viewmodel.WeatherViewModel
import com.example.presentation.weatherdetail.viewmodel.WeatherDetailViewModel
import com.example.ui.weather.WeatherScreen
import com.example.ui.weatherdetail.WeatherDetailScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun WeatherNavHost(
    navController: NavHostController,
    modifier: Modifier,
    weatherViewModel: WeatherViewModel,
    weatherDetailViewModel: WeatherDetailViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = OverView.route,
        modifier = modifier,
    ) {
        composable(route = OverView.route) {
            WeatherScreen(
                viewModel = weatherViewModel,
                onWeatherClicked = { navController.navigateToSingleWeather(it) }
            )
        }
        composable(route = Search.route) {

        }
        composable(route = Favorite.route) {
            // screen
        }
        composable(
            route = SingleWeather.routeWithArgs,
            arguments = SingleWeather.arguments,
            deepLinks = SingleWeather.deepLinks
        ) { navBackStackEntry ->
            val latLng = navBackStackEntry.arguments?.getString(SingleWeather.latLngArg)
            WeatherDetailScreen(
                viewModel = weatherDetailViewModel,
                latLng = latLng
            )
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
    this.navigate("${SingleWeather.route}/$latLng") {
        popUpTo(
            this@navigateToSingleWeather.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = false
    }
}
