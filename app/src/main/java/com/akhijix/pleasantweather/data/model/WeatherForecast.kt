package com.akhijix.pleasantweather.data.model

data class WeatherForecast (
    val list: List<WeatherItem>,
    val city: CityData
)