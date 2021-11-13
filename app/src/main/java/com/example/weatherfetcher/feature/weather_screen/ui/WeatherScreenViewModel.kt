package com.example.weatherfetcher.feature.weather_screen.ui

import androidx.lifecycle.ViewModel
import com.example.weatherfetcher.feature.weather_screen.WeatherInteractor

class WeatherScreenViewModel(val interactor: WeatherInteractor) : ViewModel() {

    suspend fun getWeather(): String {
        return interactor.getWeather()
    }
}