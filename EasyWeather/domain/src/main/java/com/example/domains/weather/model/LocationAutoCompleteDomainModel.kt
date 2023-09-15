package com.example.domains.weather.model

data class LocationAutoCompleteDomainModel (
    val locationAutoCompleteList: List<LocationDomainModel>,
)

data class LocationDomainModel(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lng: Double,
)