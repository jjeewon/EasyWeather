package com.example.datasource.weather.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AutoCompleteApiResponse(
    @SerializedName("forecast") val forecast: Forecast
): Parcelable