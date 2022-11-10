package com.example.weatherfetcher.feature.data

import com.example.weatherfetcher.feature.weather_screen.di.API_KEY
import com.example.weatherfetcher.feature.data.model.WeatherMainRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("weather")
    suspend fun getWeather(
        @Query("q") query: String = "Moscow",
        @Query("units") units: String = "metric",
        @Query("appid") apiKey: String = API_KEY
    ): WeatherMainRemoteModel
}