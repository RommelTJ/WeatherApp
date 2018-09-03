package com.rommelrico.weatherapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherAPI {

    @GET("bins/r8vzg")
    fun getForecast(): Call<List<Forecast>>
}

class Forecast(val high: String, val low: String)

class WeatherRetriever {
    val service: WeatherAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        this.service = retrofit.create(WeatherAPI::class.java)
    }
}
