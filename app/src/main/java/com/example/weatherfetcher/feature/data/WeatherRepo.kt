package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.weather_screen.domain.model.WeatherModel

interface WeatherRepo {

   suspend fun getWeather(): WeatherModel
}