package com.rommelrico.weatherapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// WeatherAPI
interface WeatherAPI {

    @GET("yql?&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    fun getForecast(@Query("q") q: String): Call<Weather>

} // end WeatherAPI

// Forecast class
class Forecast(val high: String, val low: String)

// Weather model
class Weather(val query: WeatherQuery)
class WeatherQuery(val results: WeatherResults)
class WeatherResults(val channel: WeatherChannel)
class WeatherChannel(val title: String, val item: WeatherItem)
class WeatherItem(val forecast: List<WeatherForecast>)
class WeatherForecast(val date: String, val day: String, val high: String, val low: String, val text: String)

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

    fun getForecast(searchTerm: String, callback: Callback<Weather>) {
        var mySearchTerm = searchTerm
        if (searchTerm == "") {
            mySearchTerm = "San Diego, CA"
        }
        val q = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"$mySearchTerm\")"
        val call = service.getForecast(q)
        call.enqueue(callback)
    }

} // end WeatherRetriever
