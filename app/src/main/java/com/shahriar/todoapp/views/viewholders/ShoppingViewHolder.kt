package com.shahriar.todoapp.views.viewholders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shahriar.todoapp.R

class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var item_name:TextView = itemView.findViewById(R.id.item_name)
    var item_amount:TextView = itemView.findViewById(R.id.item_amount)
}