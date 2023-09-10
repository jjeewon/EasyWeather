package com.example.presentation.weather.mapper

import com.example.domains.weather.model.WeatherDomainModel
import com.example.presentation.weather.model.WeatherPresentationModel
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class WeatherDomainToPresentationMapper {
    fun toPresentation(input: WeatherDomainModel): WeatherPresentationModel {
        val instant = Instant.ofEpochSecond(input.lastUpdated)
        val localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
        val formatter = DateTimeFormatter.ofPattern(" yyyy MMMM dd hh:mm a")
        val date = localDateTime.format(formatter)

        return WeatherPresentationModel(
            lastUpdated = date,
            name = input.name,
            region = input.region,
            tempC = input.tempC,
            tempF = input.tempF,
            humidity = input.humidity,
            condition = input.condition,
            conditionIcon = input.conditionIcon
        )
    }

}