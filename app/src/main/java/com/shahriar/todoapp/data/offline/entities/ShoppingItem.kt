package com.shahriar.todoapp.data.offline.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    @ColumnInfo
    var itemName: String,
    @ColumnInfo
    var amount: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    override fun toString(): String {
        return "ShoppingItem(itemName= $itemName, amount= $amount, id= $id)"
    }
}