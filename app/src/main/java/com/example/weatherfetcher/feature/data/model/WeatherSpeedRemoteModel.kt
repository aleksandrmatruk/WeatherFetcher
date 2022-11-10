package com.example.weatherfetcher.feature.data.model

import com.google.gson.annotations.SerializedName

data class WeatherSpeedRemoteModel (
    @SerializedName("speed")
    val speed: Float
        )