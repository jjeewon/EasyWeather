package com.example.data.weather.model

data class LocationAutoCompleteDataModel(
    val locationAutoCompleteList: List<LocationDataModel>,
)

data class LocationDataModel(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lng: Double,
)