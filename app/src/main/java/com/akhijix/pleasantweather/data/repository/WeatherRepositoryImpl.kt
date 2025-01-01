package com.akhijix.pleasantweather.data.repository

import com.akhijix.pleasantweather.data.model.CurrentWeather
import com.akhijix.pleasantweather.data.model.WeatherForecast
import com.akhijix.pleasantweather.data.remote.WeatherApi
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherForecast(latitude: Double, longitude: Double): WeatherForecast {
        return weatherApi.getWeatherForecast(latitude, longitude)
    }

    override suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather {
        return weatherApi.getCurrentWeather(latitude, longitude)
    }
}