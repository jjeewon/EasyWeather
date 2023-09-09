package com.example.easyweather.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.presentation.weather.viewmodel.WeatherViewModel
import com.example.presentation.weatherdetail.viewmodel.WeatherDetailViewModel
import com.example.ui.theme.WeatherTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherApp(
    weatherViewModel: WeatherViewModel,
    weatherDetailViewModel: WeatherDetailViewModel,
) {
    WeatherTheme {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            weatherTabRowScreens.find { it.route == currentDestination?.route } ?: OverView

        Scaffold(
            bottomBar = {
                WeatherTabRow(
                    allScreens = weatherTabRowScreens,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen
                )
            }
        ) { innerPadding ->
            WeatherNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                weatherViewModel,
                weatherDetailViewModel,
            )
        }
    }
}