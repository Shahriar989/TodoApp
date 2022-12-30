package com.shahriar.todoapp.data.offline.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shahriar.todoapp.data.offline.daos.ShoppingDao
import com.shahriar.todoapp.data.offline.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1,
    exportSchema = false
)
abstract class ShoppingDatabase : RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {

        fun getDb(context: Context): ShoppingDatabase {

            var instance: ShoppingDatabase? = null

            return if (instance == null) {

                instance = Room.databaseBuilder(
                    context,
                    ShoppingDatabase::class.java,
                    "Shopping_DB",
                ).build()
                instance
            } else {
                instance
            }
        }
    }
}