package com.rommelrico.weatherapp

import retrofit2.Call
import retrofit2.http.GET

interface WeatherAPI {

    @GET("bins/r8vzg")
    fun getForecast(): Call<List<Forecast>>
}

class Forecast(val high: String, val low: String)
