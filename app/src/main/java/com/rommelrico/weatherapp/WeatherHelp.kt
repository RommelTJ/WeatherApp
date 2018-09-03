package com.rommelrico.weatherapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// WeatherAPI
interface WeatherAPI {

    @GET("bins/r8vzg")
    fun getForecast(): Call<List<Forecast>>

} // end WeatherAPI

// Forecast class
class Forecast(val high: String, val low: String)

// WeatherRetriever class
class WeatherRetriever {
    private val service: WeatherAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        this.service = retrofit.create(WeatherAPI::class.java)
    }

    fun getForecast(callback: Callback<List<Forecast>>) {
        val call = service.getForecast()
        call.enqueue(callback)
    }

} // end WeatherRetriever
