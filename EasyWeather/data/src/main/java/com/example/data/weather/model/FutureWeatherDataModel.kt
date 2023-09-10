package com.example.data.weather.model

data class FutureWeatherDataModel(
    val date: String,
    val maxtemp_c: Double,
    val maxtemp_f: Double,
    val mintemp_c: Double,
    val mintemp_f: Double,
    val avgtemp_c: Double,
    val avgtemp_f: Double,
    val maxwind_mph: Double,
    val maxwind_kph: Double,
    val avghumidity: Double,
    val condition: String,
    val hourList: List<HourDataModel>
)

data class HourDataModel(
    val time_epoch: Long,
    val time: String,
    val temp_c: Double,
    val temp_f: Double,
    val condition: String,
    val conditionIcon: String,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val humidity: Int,
    val cloud: Int,
    val will_it_rain: Int,
    val chance_of_rain: Int,
    val will_it_snow: Int,
    val chance_of_snow: Int,
)