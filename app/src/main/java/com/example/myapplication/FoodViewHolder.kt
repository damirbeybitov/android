package com.example.myapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView
    val foodName: TextView
    val foodDescription: TextView

    init {
        imageView = itemView.findViewById(R.id.imageView)
        foodName = itemView.findViewById(R.id.foodName)
        foodDescription = itemView.findViewById(R.id.foodDescription)
    }
}