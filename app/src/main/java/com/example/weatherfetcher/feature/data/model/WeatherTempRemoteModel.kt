package com.example.weatherfetcher.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeatherTempRemoteModel(
    @SerializedName("temp")
    val temperature: Float
)