package com.example.tmdbapp_002

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {
    @GET("discover/movie?include_adult=false&include_video=false&language=en-US&sort_by=popularity.desc")
    suspend fun getPosts(
        @Header("Authorization") authHeader: String,
        @Query("page") page: Int // Sayfa parametresini eklemek
    ): APIResponseData
}

// Retrofit yapısını oluştururken interceptor, converter gibi diğer ayarları buraya ekleyebilirsiniz.
val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/") // API'nin temel URL'si
    .addConverterFactory(GsonConverterFactory.create()) // JSON dönüşümü için Gson kullanımı
    .build()

val apiInterface = retrofit.create(ApiInterface::class.java)

val currentPage = 1 // İstediğiniz sayfa numarası
val authKey = "Bearer your_auth_token" // Auth tokenınızı buraya ekleyin

