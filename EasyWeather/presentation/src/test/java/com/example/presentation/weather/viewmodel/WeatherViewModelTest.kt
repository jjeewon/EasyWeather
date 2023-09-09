package com.example.presentation.weather.viewmodel

import app.cash.turbine.test
import com.example.domains.architecture.usecase.UseCaseExecutor
import com.example.domains.weather.model.WeatherDomainModel
import com.example.domains.weather.usecase.GetWeatherUseCase
import com.example.presentation.weather.mapper.WeatherDomainToPresentationMapper
import com.example.presentation.weather.model.WeatherOverViewUiState
import com.example.presentation.weather.model.WeatherUiState
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
class WeatherViewModelTest {
    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `when getWeatherFromLocation is successful, then updated UiState is emitted`() = testDispatcher.runBlockingTest {
        // Given
        val getWeatherUseCase = mockk<GetWeatherUseCase>()
        coEvery {
            getWeatherUseCase.executeInBackground(any())
        } returns FAKE_WEATHER_DOMAIN_MODEL

        val weatherDomainToPresentationMapper = WeatherDomainToPresentationMapper()
        val viewModel = WeatherViewModel(getWeatherUseCase, weatherDomainToPresentationMapper, UseCaseExecutor())
        viewModel.getWeatherFromLocation(FAKE_LAT, FAKE_LNG)

        // When & Then
        viewModel.uiState.test {
            assertEquals(WeatherUiState(
                isLoading = false,
                weatherOverViewUiState = FAKE_WEATHER_DETAIL_UI_STATE
            ), awaitItem())
        }
    }

    companion object {
        private const val FAKE_LAT = 51.52
        private const val FAKE_LNG = -0.11
        private const val FAKE_NAME = "London"
        private const val FAKE_REGION = "City of London, Greater London"
        private const val FAKE_TEMP = 18.0
        private const val FAKE_HUMIDITY = 56
        private const val FAKE_CONDITION = "Partly cloudy"
        private const val FAKE_CONDITION_ICON = "//cdn.weatherapi.com/weather/64x64/day/116.png"

        private val FAKE_WEATHER_DOMAIN_MODEL = WeatherDomainModel(
            name= FAKE_NAME,
            region= FAKE_REGION,
            tempC = FAKE_TEMP,
            tempF = FAKE_TEMP,
            humidity= FAKE_HUMIDITY,
            condition= FAKE_CONDITION,
            conditionIcon= FAKE_CONDITION_ICON
        )

        private val FAKE_WEATHER_DETAIL_UI_STATE =  WeatherOverViewUiState.Visible(
            name= FAKE_NAME,
            region= FAKE_REGION,
            temp= FAKE_TEMP.toString(),
            humidity= FAKE_HUMIDITY.toString(),
            condition= FAKE_CONDITION,
            conditionIcon= FAKE_CONDITION_ICON
        )
    }
}