package com.example.weatherfetcher.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeatherMainRemoteModel(
    @SerializedName("main")
    val main: WeatherTempRemoteModel,
    @SerializedName("wind")
    val wind: WeatherSpeedRemoteModel
)

