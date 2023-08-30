package com.example.datasource

import com.example.datasource.weather.model.WeatherApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/v1/current.json")
    suspend fun getWeather(
        @Query("q") q: String,
        @Query("aqi") aqi: String = "no",
    ): WeatherApiResponse
}