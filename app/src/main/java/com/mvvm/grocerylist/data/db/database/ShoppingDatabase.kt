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
}