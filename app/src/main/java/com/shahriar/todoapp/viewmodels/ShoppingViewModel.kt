package com.shahriar.todoapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.shahriar.todoapp.data.offline.db.ShoppingDatabase
import com.shahriar.todoapp.data.offline.entities.ShoppingItem
import com.shahriar.todoapp.data.offline.repositories.ShoppingRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application) : AndroidViewModel(application){

    private val repo: ShoppingRepo

    init {
        val db = ShoppingDatabase.getDb(application.applicationContext)
        repo = ShoppingRepo(db)
    }

    fun insertItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repo.insert(item)
    }

    fun updateItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repo.update(item)
    }

    fun deleteItem(item: ShoppingItem) = CoroutineScope(Dispatchers.IO).launch {
        repo.delete(item)
    }

    fun getAllItem() = repo.getAllShoppingItem()
}