package com.akhijix.pleasantweather.domain.usecase

import com.akhijix.pleasantweather.data.model.CurrentWeather
import com.akhijix.pleasantweather.data.repository.WeatherRepository
import javax.inject.Inject

class GetCurrentWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(latitude: Double, longitude: Double): CurrentWeather {
        return weatherRepository.getCurrentWeather(latitude, longitude)
    }
}