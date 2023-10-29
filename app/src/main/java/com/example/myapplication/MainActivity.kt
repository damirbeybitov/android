package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val foods = mutableListOf(
            Food(name = "Pizza", description = "A savory dish made with a flattened base of leavened wheat-based dough topped with tomatoes, cheese, and various other ingredients.", image = R.drawable.pizza_image),
            Food(name = "Burger", description = "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", image = R.drawable.burger_image),
            Food(name = "Doner", description = "A type of kebab, made of meat cooked on a vertical rotisserie.", image = R.drawable.doner_image),
            Food(name = "Sushi", description = "A Japanese dish of prepared vinegared rice, accompanied by various ingredients such as seafood, vegetables, and occasionally tropical fruits.", image = R.drawable.sushi_image),
            Food(name = "Cola", description = "A sweet carbonated drink made with caramelized sugar, caffeine, and other flavorings.", image = R.drawable.cola_image),
            Food(name = "Pizza", description = "A savory dish made with a flattened base of leavened wheat-based dough topped with tomatoes, cheese, and various other ingredients.", image = R.drawable.pizza_image),
            Food(name = "Burger", description = "A sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun.", image = R.drawable.burger_image),
            Food(name = "Doner", description = "A type of kebab, made of meat cooked on a vertical rotisserie.", image = R.drawable.doner_image),
            Food(name = "Sushi", description = "A Japanese dish of prepared vinegared rice, accompanied by various ingredients such as seafood, vegetables, and occasionally tropical fruits.", image = R.drawable.sushi_image),
            Food(name = "Cola", description = "A sweet carbonated drink made with caramelized sugar, caffeine, and other flavorings.", image = R.drawable.cola_image)
        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FoodAdapter(applicationContext, foods)



    }
}