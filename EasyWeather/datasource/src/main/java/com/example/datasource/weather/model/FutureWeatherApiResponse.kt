package com.example.datasource.weather.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FutureWeatherApiResponse(
    @SerializedName("forecast") val forecast: Forecast
): Parcelable

@Parcelize
data class Forecast(
    @SerializedName("forecastday")  val forecastday: List<ForecastDay>
): Parcelable

@Parcelize
data class ForecastDay(
    @SerializedName("date") val date: String,
    @SerializedName("date_epoch") val date_epoch: Long,
    @SerializedName("day") val day: Day,
    @SerializedName("hour") val hour: List<Hour>
): Parcelable

@Parcelize
data class Day(
    val maxtemp_c: Double,
    val maxtemp_f: Double,
    val mintemp_c: Double,
    val mintemp_f: Double,
    val avgtemp_c: Double,
    val avgtemp_f: Double,
    val maxwind_mph: Double,
    val maxwind_kph: Double,
    val totalprecip_mm: Double,
    val totalprecip_in: Double,
    val avgvis_km: Double,
    val avgvis_miles: Double,
    val avghumidity: Double,
    val condition: Condition,
    val uv: Double
): Parcelable

@Parcelize
data class Hour(
    val time_epoch: Long,
    val time: String,
    val temp_c: Double,
    val temp_f: Double,
    val is_day: Int,
    val condition: Condition,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val pressure_mb: Double,
    val pressure_in: Double,
    val precip_mm: Double,
    val precip_in: Double,
    val humidity: Int,
    val cloud: Int,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val windchill_c: Double,
    val windchill_f: Double,
    val heatindex_c: Double,
    val heatindex_f: Double,
    val dewpoint_c: Double,
    val dewpoint_f: Double,
    val will_it_rain: Int,
    val chance_of_rain: Int,
    val will_it_snow: Int,
    val chance_of_snow: Int,
    val vis_km: Double,
    val vis_miles: Double,
    val gust_mph: Double,
    val gust_kph: Double
): Parcelable