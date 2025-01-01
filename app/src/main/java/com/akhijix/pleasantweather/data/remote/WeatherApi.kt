package com.akhijix.pleasantweather.data.remote

import com.akhijix.pleasantweather.BuildConfig.API_KEY
import com.akhijix.pleasantweather.data.model.CurrentWeather
import com.akhijix.pleasantweather.data.model.WeatherForecast
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String = API_KEY,
        @Query("units") units: String = "metric"
    ): WeatherForecast

    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") apiKey: String = API_KEY,
        @Query("units") units: String = "metric"
    ): CurrentWeather
}