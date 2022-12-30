package com.shahriar.todoapp.data.offline.repositories

import com.shahriar.todoapp.data.offline.db.ShoppingDatabase
import com.shahriar.todoapp.data.offline.entities.ShoppingItem

class ShoppingRepo (private val db: ShoppingDatabase){

    suspend fun insert(item: ShoppingItem) = db.getShoppingDao().insert(item)
    suspend fun update(item: ShoppingItem) = db.getShoppingDao().update(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllData()
}