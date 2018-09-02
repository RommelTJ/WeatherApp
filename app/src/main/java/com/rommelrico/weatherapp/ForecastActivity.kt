package com.rommelrico.weatherapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var listView = findViewById<ListView>(R.id.forecastListView)!!

        var randomThings = listOf("Hello", "How are you?", "I like cheese")

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, randomThings)
        listView.adapter = adapter
    }
}
