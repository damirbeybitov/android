package com.example.myapplication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users
    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    fun loadUsers() {
        // Инициализация Retrofit (пример, возможно, требуется адаптация под ваш код)
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)

        // Совершение асинхронного вызова
        apiInterface.getUsers().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    // Обновление LiveData
                    _users.value = response.body()
                } else {
                    // Обработка ошибки
                    Log.e("MainViewModel", "Ошибка загрузки пользователей: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Обработка сбоя запроса
                Log.e("MainViewModel", "Сбой запроса: ${t.message}")
            }
        })
    }
}

