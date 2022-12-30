package com.shahriar.todoapp.data.offline.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.shahriar.todoapp.data.offline.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Update
    suspend fun update(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllData(): LiveData<List<ShoppingItem>>
}