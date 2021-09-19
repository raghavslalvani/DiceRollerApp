package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news: Call<News> = NewService.newsInstance.getHeadline(country = "us", page = 1)
        news.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news != null)
                    Log.d("CODE", news.toString())
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("CODE", "Error in Fetching News", t)
            }
        })
    }
}