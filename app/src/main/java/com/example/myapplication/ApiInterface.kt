package com.example.myapplication

import UserDetails
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface{
    @GET("/users")
    fun getUsers(): Call<List<User>>

    @GET("/users/{id}")
    fun getUserDetails(@Path("id") id: Int): Call<UserDetails>
}
