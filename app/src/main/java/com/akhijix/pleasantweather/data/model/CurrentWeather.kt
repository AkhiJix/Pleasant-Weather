package com.akhijix.pleasantweather.data.model

data class CurrentWeather (
    val weather: List<WeatherCondition>,
    val main: MainData,
    val wind: Wind,
    val name: String
)