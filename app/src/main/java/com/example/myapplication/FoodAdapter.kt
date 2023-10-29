package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val context: Context, private val foods: List<Food>) : RecyclerView.Adapter<FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view, parent, false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.imageView.setImageResource(foods[position].image)
        holder.foodName.text = foods[position].name
        holder.foodDescription.text = foods[position].description
    }

    override fun getItemCount(): Int {
        return foods.size
    }


}


