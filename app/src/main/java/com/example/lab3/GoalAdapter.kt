package com.example.lab3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class GoalAdapter(private val context: Context, private val dataSet: Array<Goal>) : RecyclerView.Adapter<GoalAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val goalTitle: TextView = view.findViewById(R.id.goal_title)
        val image: ImageView = view.findViewById(R.id.image)
        val description: TextView = view.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goal, parent, false)
        val card: CardView = view.findViewById(R.id.card)
        val cardLayoutParams = card.layoutParams
        val scale = context.resources.displayMetrics.density

        view.setOnClickListener {
            if (cardLayoutParams.height == LayoutParams.WRAP_CONTENT) {
                cardLayoutParams.height = (310.0 * scale).toInt()
            } else {
                cardLayoutParams.height = LayoutParams.WRAP_CONTENT
            }
            card.layoutParams = cardLayoutParams
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.goalTitle.text = dataSet[position].title
        holder.image.setImageResource(dataSet[position].image)
        holder.description.text = dataSet[position].description
    }

    override fun getItemCount(): Int = dataSet.size
}