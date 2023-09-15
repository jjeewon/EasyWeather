package com.example.datasource.weather.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherApiResponse (
   @SerializedName("location") val location: LocationModel,
   @SerializedName("current") val current: CurrentModel,
): Parcelable

@Parcelize
data class LocationModel (
   @SerializedName("name") val name: String,
   @SerializedName("region") val region: String,
   @SerializedName("country") val country: String,
   @SerializedName("localtime") val localtime: String,
   @SerializedName("lat") val lat: Double,
   @SerializedName("lon") val lon: Double,
): Parcelable

@Parcelize
data class CurrentModel(
   @SerializedName("last_updated_epoch") val lastUpdatedEpoch: Long,
   @SerializedName("last_updated") val lastUpdated: String,
   @SerializedName("temp_c") val tempC: Double,
   @SerializedName("temp_f") val tempF: Double,
   @SerializedName("condition") val condition: Condition,
   @SerializedName("wind_mph") val windMph: Double,
   @SerializedName("wind_kph") val windKph: Double,
   @SerializedName("wind_degree") val windDegree: Int,
   @SerializedName("wind_dir") val windDir: String,
   @SerializedName("pressure_mb") val pressureMb: Double,
   @SerializedName("pressure_in") val pressureIn: Double,
   @SerializedName("humidity") val humidity: Int,
   @SerializedName("cloud") val cloud: Int,
   @SerializedName("vis_km") val visKm: Double,
   @SerializedName("vis_miles") val visMiles: Double,
   @SerializedName("uv") val uv: Double,
   @SerializedName("gust_mph") val gustMph: Double,
   @SerializedName("gust_kph") val gustKph: Double
): Parcelable

@Parcelize
data class Condition(
   @SerializedName("text") val text: String,
   @SerializedName("icon") val icon: String,
   @SerializedName("code") val code: Int
): Parcelable