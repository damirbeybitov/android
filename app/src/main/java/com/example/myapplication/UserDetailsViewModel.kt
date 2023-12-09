package com.example.myapplication

import UserDetails
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserDetailsViewModel : ViewModel() {
    private val _userDetails = MutableLiveData<UserDetails>()
    val userDetails: LiveData<UserDetails> = _userDetails
    private val BASE_URL = "https://jsonplaceholder.typicode.com"


    fun loadUserDetails(userId: Int) {
        // Инициализация Retrofit (пример, возможно, требуется адаптация под ваш код)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)

        apiInterface.getUserDetails(userId).enqueue(object : Callback<UserDetails> {
            override fun onResponse(call: Call<UserDetails>, response: Response<UserDetails>) {
                if (response.isSuccessful) {
                    _userDetails.value = response.body()
                } else {
                    Log.e("UserDetailsViewModel", "Ошибка загрузки деталей пользователя: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<UserDetails>, t: Throwable) {
                Log.e("UserDetailsViewModel", "Сбой запроса: ${t.message}")
            }
        })
    }
}

