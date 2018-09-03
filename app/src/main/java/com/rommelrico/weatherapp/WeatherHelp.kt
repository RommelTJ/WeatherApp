package com.rommelrico.weatherapp

import retrofit2.Call

interface WeatherAPI {
    fun getForecast(): Call<List<Forecast>>
}
