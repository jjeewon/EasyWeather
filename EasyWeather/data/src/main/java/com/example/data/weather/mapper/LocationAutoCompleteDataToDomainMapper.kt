package com.example.data.weather.mapper

import com.example.data.weather.model.LocationAutoCompleteDataModel
import com.example.domains.weather.model.LocationAutoCompleteDomainModel
import com.example.domains.weather.model.LocationDomainModel

class LocationAutoCompleteDataToDomainMapper {
    fun toDomain(input: LocationAutoCompleteDataModel) = LocationAutoCompleteDomainModel(
        locationAutoCompleteList = input.locationAutoCompleteList.map {
            LocationDomainModel(
                name = it.name,
                region = it.region,
                country = it.country,
                lat = it.lat,
                lng = it.lng,
            )
        },
    )
}