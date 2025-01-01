package com.akhijix.pleasantweather.domain.usecase

import android.location.Location
import com.akhijix.pleasantweather.data.repository.LocationRepository
import javax.inject.Inject

class GetDeviceLocationUseCase @Inject constructor(
    private val locationRepository: LocationRepository
) {
    suspend operator fun invoke(): Location? {
        print("GetDeviceLocationUseCase")
        return locationRepository.getDeviceLocation()
    }
}