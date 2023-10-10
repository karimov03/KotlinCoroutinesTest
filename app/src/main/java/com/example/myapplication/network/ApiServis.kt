package com.example.myapplication.network

import com.example.myapplication.models.Valyuta
import retrofit2.Call
import retrofit2.http.GET

interface ApiServis {
    @GET("json")
    fun getServis():Call<ArrayList<Valyuta>>
}