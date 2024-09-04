package com.example.fetchrewardscodingexercise

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton object for setting up Retrofit client and providing ApiService instance.
object RetrofitClient {
    private const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"

    // Lazily initialized Retrofit instance for making API calls.
    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL) // Base URL for API
            .addConverterFactory(GsonConverterFactory.create()) // Converter for JSON data
            .build()
            .create(ApiService::class.java) // Create ApiService implementation
    }
}
