package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Инициализация RecyclerView и его адаптера
        recyclerView = findViewById(R.id.rview) // Предполагается, что у вас есть RecyclerView с id rview
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(mutableListOf()) { user ->
            // Обработка клика по элементу списка
            val intent = Intent(this@MainActivity, UserDetailsActivity::class.java)
            intent.putExtra("USER_ID", user.id) // Передаем ID пользователя в UserDetailsActivity
            startActivity(intent)
        }
        recyclerView.adapter = userAdapter

        // Инициализация ViewModel
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Наблюдение за изменениями данных в ViewModel
        viewModel.users.observe(this, Observer { users ->
            // Обновление адаптера RecyclerView при изменении данных
            userAdapter.updateUsers(users)
        })

        // Загрузка данных пользователей
        viewModel.loadUsers()
    }
}