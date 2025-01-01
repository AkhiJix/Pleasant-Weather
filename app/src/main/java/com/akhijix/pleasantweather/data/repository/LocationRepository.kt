package com.akhijix.pleasantweather.data.repository

import android.location.Location

interface LocationRepository  {
    suspend fun getDeviceLocation(): Location?
}