package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.data.model.WeatherMainRemoteModel
import com.example.weatherfetcher.feature.weather_screen.domain.model.WeatherModel

fun WeatherMainRemoteModel.toDomain() = WeatherModel(
    temp = main.temperature,
    speed = wind.speed
)
