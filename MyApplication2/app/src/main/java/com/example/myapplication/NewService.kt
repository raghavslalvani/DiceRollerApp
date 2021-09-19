package com.example.myapplication

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=83ec003700254a369cefd9c927c2547f
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=83ec003700254a369cefd9c927c2547f

const val BASE_URL = "https://newsapi.org/v2/"
const val API_KEY = "83ec003700254a369cefd9c927c2547f"
interface NewsInterface {
    @GET("v2/top-headlines?apiKey=API_KEY")
    fun getHeadline(@Query("country") country : String, @Query("page") page : Int) : Call<News>

}
object NewService{
    val newsInstance: NewsInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}