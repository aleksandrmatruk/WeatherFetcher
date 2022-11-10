package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.data.model.WeatherMainRemoteModel

class WeatherRemoteSource(private val api: WeatherApi) {


    suspend fun getWeather(): WeatherMainRemoteModel = api.getWeather()

    }