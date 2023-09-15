package com.example.datasource.weather.mapper

import com.example.data.weather.model.LocationAutoCompleteDataModel
import com.example.data.weather.model.LocationDataModel
import com.example.datasource.weather.model.LocationModel

class LocationAutoCompleteToDataMapper {
    fun toData(res: List<LocationModel>) = LocationAutoCompleteDataModel(
        locationAutoCompleteList = res.map {
            LocationDataModel(
                name = it.name,
                region = it.region,
                country = it.country,
                lat = it.lat,
                lng = it.lon,
            )
        }
    )
}