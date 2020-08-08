package com.mvvm.grocerylist.data.db.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mvvm.grocerylist.data.db.entity.ShoppingItem
import com.mvvm.grocerylist.data.db.dao.ShoppingDao

@Database(
    entities = [ShoppingItem::class],
    version  = 1
)
abstract class ShoppingDatabase  : RoomDatabase(){

    abstract fun getDao() : ShoppingDao

    // Singleton prevents multiple instances of database opening at the
    // same time
    companion object{

        @Volatile
        private var INSTANCE: ShoppingDatabase? = null

        fun getDatabase(context: Context): ShoppingDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppingDatabase::class.java,
                    "shopping_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}