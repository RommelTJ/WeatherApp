package com.rommelrico.weatherapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// WeatherAPI
interface WeatherAPI {

    @GET("yql?q=select * from weather.forecast where woeid in (select woeid from geo.places(1) where text%3D\"san diego%2C ca\")&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    fun getForecast(): Call<WeatherQuery>

} // end WeatherAPI

// Forecast class
class Forecast(val high: String, val low: String)

// WeatherQuery class
class WeatherQuery()

// WeatherRetriever class
class WeatherRetriever {
    private val service: WeatherAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com/v1/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        this.service = retrofit.create(WeatherAPI::class.java)
    }

    fun getForecast(callback: Callback<List<Forecast>>) {
        val call = service.getForecast()
        call.enqueue(callback)
    }

} // end WeatherRetriever
