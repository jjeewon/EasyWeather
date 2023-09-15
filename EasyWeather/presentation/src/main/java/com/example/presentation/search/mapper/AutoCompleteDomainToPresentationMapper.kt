package com.example.presentation.search.mapper

import com.example.domains.weather.model.LocationAutoCompleteDomainModel
import com.example.presentation.search.model.AutoCompletePresentationModel
import com.example.presentation.search.model.LocationPresentationModel

class AutoCompleteDomainToPresentationMapper {
    fun toPresentation(input: LocationAutoCompleteDomainModel) = AutoCompletePresentationModel(
        list = input.locationAutoCompleteList.map {
            val location = "${it.name}, ${it.country}"
            LocationPresentationModel(
                location = location,
                lat = it.lat,
                lng = it.lng,
            )
        }
    )
}