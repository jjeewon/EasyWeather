package com.example.presentation.search.model

class AutoCompletePresentationModel (
    val list: List<LocationPresentationModel>
)

data class LocationPresentationModel(
    val location: String,
    val lat: Double,
    val lng: Double,
)