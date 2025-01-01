package com.akhijix.pleasantweather.domain.usecase

import com.akhijix.pleasantweather.data.model.WeatherForecast
import com.akhijix.pleasantweather.data.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherForecastUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(latitude: Double, longitude: Double): WeatherForecast {
        return weatherRepository.getWeatherForecast(latitude, longitude)
    }
}