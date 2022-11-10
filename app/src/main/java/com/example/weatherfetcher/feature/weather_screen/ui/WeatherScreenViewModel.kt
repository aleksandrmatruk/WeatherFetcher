package com.example.weatherfetcher.feature.weather_screen.ui

import androidx.lifecycle.viewModelScope
import com.example.weatherfetcher.base.BaseViewModel
import com.example.weatherfetcher.base.Event
import com.example.weatherfetcher.feature.weather_screen.domain.WeatherInteractor
import com.example.weatherfetcher.feature.weather_screen.domain.model.WeatherModel
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor) : BaseViewModel<ViewState>() {


    init {
        processDataEvent(DataEvent.LoadWeather)
    }

    override fun initialViewState(): ViewState = ViewState(
        weather = WeatherModel(0f, 0f)
    )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnButtonClicked -> {
                viewModelScope.launch {
                    interactor.getWeather().fold(
                        onError = {
                            processDataEvent(DataEvent.OnWeatherFetchFailed(error = it))
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnWeatherFetchSucceed(it))
                        }
                    )
                }
                return null
            }

            is DataEvent.OnWeatherFetchSucceed -> {
                return previousState.copy(weather = event.data)
            }

            else -> return null
        }
    }
}