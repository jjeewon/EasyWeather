package com.example.datasource.weather.mapper

import com.example.data.weather.model.WeatherDataModel
import com.example.datasource.weather.model.WeatherApiResponse

class WeatherToDataMapper {
    fun toData(res: WeatherApiResponse) = WeatherDataModel(
        name = res.location.name,
        region = res.location.region,
        tempC = res.current.tempC,
        tempF = res.current.tempF,
        humidity = res.current.humidity,
        condition = res.current.condition.text,
        conditionIcon = res.current.condition.icon
    )
}
