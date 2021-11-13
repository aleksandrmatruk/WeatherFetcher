package com.example.weatherfetcher

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherfetcher.feature.weather_screen.ui.WeatherScreenViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: WeatherScreenViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var weather = ""
        val textViewHello = findViewById<TextView>(R.id.tvHello)

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                textViewHello.text = viewModel.getWeather()
            }
        }
    }
}