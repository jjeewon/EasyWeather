package com.example.datasource.weather.mapper

import android.util.Log
import com.example.data.weather.model.FutureWeatherDataModel
import com.example.data.weather.model.HourDataModel
import com.example.datasource.weather.model.FutureWeatherApiResponse

class FutureWeatherToDataMapper {
    fun toData(res: FutureWeatherApiResponse): FutureWeatherDataModel {
        val forecastWeather = res.forecast.forecastday.firstOrNull() ?: throw IllegalStateException("failed to get forecast weather")
        val date = forecastWeather.date
        val day = forecastWeather.day
        val hourList = forecastWeather.hour.map {
            HourDataModel(
                time_epoch = it.time_epoch,
                time = it.time,
                temp_c = it.temp_c,
                temp_f = it.temp_f,
                condition = it.condition.text,
                conditionIcon = it.condition.icon,
                wind_mph = it.wind_mph,
                wind_kph = it.wind_kph,
                wind_degree = it.wind_degree,
                wind_dir = it.wind_dir,
                humidity = it.humidity,
                cloud = it.cloud,
                will_it_rain = it.will_it_rain,
                chance_of_rain = it.chance_of_rain,
                will_it_snow = it.will_it_snow,
                chance_of_snow = it.chance_of_snow
            )
        }
        Log.i("gomdol", day.condition.text)
        return FutureWeatherDataModel(
            date = date,
            maxtemp_c = day.maxtemp_c,
            maxtemp_f = day.maxtemp_f,
            mintemp_c = day.mintemp_c,
            mintemp_f = day.mintemp_f,
            avgtemp_c = day.avgtemp_c,
            avgtemp_f = day.avgtemp_f,
            maxwind_kph = day.maxwind_kph,
            maxwind_mph = day.maxwind_mph,
            avghumidity = day.avghumidity,
            condition = day.condition.text,
            hourList = hourList
        )
    }
}
