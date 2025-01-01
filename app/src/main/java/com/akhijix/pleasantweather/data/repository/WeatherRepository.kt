package com.akhijix.pleasantweather.data.repository

import com.akhijix.pleasantweather.data.model.CurrentWeather
import com.akhijix.pleasantweather.data.model.WeatherForecast

interface WeatherRepository {
    /**
     * Get the weather forecast for a given latitude and longitude
     */
    suspend fun getWeatherForecast(latitude: Double, longitude: Double): WeatherForecast

    /**
     * Get the current weather for a given latitude and longitude
     */
    suspend fun getCurrentWeather(latitude: Double, longitude: Double): CurrentWeather
}