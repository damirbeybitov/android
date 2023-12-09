package com.example.myapplication

import UserDetails
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserDetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: UserDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        viewModel = ViewModelProvider(this).get(UserDetailsViewModel::class.java)

        val userId = intent.getIntExtra("USER_ID", -1)
        if (userId != -1) {
            // Наблюдение за LiveData с деталями пользователя
            viewModel.userDetails.observe(this, Observer { userDetails ->
                findViewById<TextView>(R.id.textViewUserId).text = "User ID: ${userDetails.id}"
                findViewById<TextView>(R.id.textViewUserName).text = "Name: ${userDetails.name}"
                findViewById<TextView>(R.id.textViewUserUsername).text = "Username: ${userDetails.username}"
                findViewById<TextView>(R.id.textViewUserEmail).text = "Email: ${userDetails.email}"
                findViewById<TextView>(R.id.textViewUserPhone).text = "Phone: ${userDetails.phone}"
                findViewById<TextView>(R.id.textViewUserWebsite).text = "Website: ${userDetails.website}"
                findViewById<TextView>(R.id.textViewUserAddress).text = "Address: ${userDetails.address.street}, ${userDetails.address.suite}, ${userDetails.address.city}, ${userDetails.address.zipcode}"
                findViewById<TextView>(R.id.textViewCompanyName).text = "Company: ${userDetails.company.name}"
                findViewById<TextView>(R.id.textViewCompanyCatchPhrase).text = "Catchphrase: ${userDetails.company.catchPhrase}"
                findViewById<TextView>(R.id.textViewCompanyBs).text = "BS: ${userDetails.company.bs}"
            })

            // Загрузка деталей пользователя
            viewModel.loadUserDetails(userId)
        } else {
            Toast.makeText(this, "Ошибка: ID пользователя не передан.", Toast.LENGTH_LONG).show()
            finish() // Закрыть активность
        }
    }
}

