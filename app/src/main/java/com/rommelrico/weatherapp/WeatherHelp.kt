package com.rommelrico.weatherapp

import retrofit2.Call

interface WeatherAPI {
    fun getForecast(): Call<List<Forecast>>
}

class Forecast(val high: String, val low: String)
