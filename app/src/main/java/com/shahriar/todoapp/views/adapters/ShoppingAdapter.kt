package com.shahriar.todoapp.views.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shahriar.todoapp.R
import com.shahriar.todoapp.data.offline.entities.ShoppingItem
import com.shahriar.todoapp.views.viewholders.ShoppingViewHolder

class ShoppingAdapter(
    var context: Context,
    var shoppingList: List<ShoppingItem>
): RecyclerView.Adapter<ShoppingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {

        var view: View= LayoutInflater.from(context).inflate(R.layout.item_shopping, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        var item = shoppingList[position]
        holder.item_name.text= item.itemName
        holder.item_amount.text= item.amount.toString()
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }
}