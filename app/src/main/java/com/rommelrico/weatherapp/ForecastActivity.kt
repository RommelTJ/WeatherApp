package com.rommelrico.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var listView = findViewById<ListView>(R.id.forecastListView)!!

        var randomThings = listOf("Hello", "How are you?", "I like cheese", "Hello", "How are you?", "I like cheese", "Hello", "How are you?", "I like cheese", "Hello", "How are you?", "I like cheese", "Hello", "How are you?", "I like cheese", "Hello", "How are you?", "I like cheese", "Hello", "How are you?", "I like cheese")

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, randomThings)
        listView.adapter = adapter

        // Calling the WeatherRetriever
        var retriever = WeatherRetriever()
        val callback = object: Callback<Weather> {

            override fun onFailure(call: Call<Weather>, t: Throwable) {
                println("Failed response")
            }

            override fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                println("Got response")
                println(response.body()?.query?.results?.channel?.title)
                title = response.body()?.query?.results?.channel?.title
            }

        }
        retriever.getForecast(callback)
    }
}
