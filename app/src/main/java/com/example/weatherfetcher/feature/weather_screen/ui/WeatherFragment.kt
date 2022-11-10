package com.example.weatherfetcher.feature.weather_screen.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.weatherfetcher.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeatherFragment : Fragment(R.layout.fragment_weather) {


    private val viewModel: WeatherScreenViewModel by viewModel()
    private val temp: TextView by lazy { requireActivity().findViewById(R.id.temp) }
    private val wind: TextView by lazy { requireActivity().findViewById(R.id.wind) }
    private val btn: Button by lazy { requireActivity().findViewById(R.id.btnStart) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.viewState.observe(viewLifecycleOwner, ::render)

        btn.setOnClickListener{
            viewModel.processUiEvent(UiEvent.OnButtonClicked)
        }

    }

    private fun render(viewState: ViewState) {
        temp.text = viewState.weather.temp.toString()
        wind.text = viewState.weather.speed.toString()

    }
}