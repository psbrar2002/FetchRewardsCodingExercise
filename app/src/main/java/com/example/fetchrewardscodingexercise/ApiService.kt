package com.example.fetchrewardscodingexercise

import retrofit2.Call
import retrofit2.http.GET

// Interface defining API endpoints for fetching data from the server.
interface ApiService {
    // API call to fetch items from the provided endpoint.
    @GET("hiring.json")
    fun getItems(): Call<List<Item>>
}
