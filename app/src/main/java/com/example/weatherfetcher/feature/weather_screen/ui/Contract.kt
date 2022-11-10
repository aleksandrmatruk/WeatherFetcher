package com.example.weatherfetcher.feature.weather_screen.ui

import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.domain.model.WeatherModel

data class ViewState(
    val weather: WeatherModel
)

sealed class UiEvent : Event {
   object OnButtonClicked : UiEvent()
}

sealed class DataEvent: Event {

    object LoadWeather: DataEvent()

    data class OnWeatherFetchSucceed(val data: WeatherModel): DataEvent()
    data class OnWeatherFetchFailed(val error: Throwable): DataEvent()
}

