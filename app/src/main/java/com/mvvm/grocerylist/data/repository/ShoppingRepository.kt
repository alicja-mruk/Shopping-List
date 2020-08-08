package com.mvvm.grocerylist.data.repository

import androidx.lifecycle.LiveData
import com.mvvm.grocerylist.data.db.database.ShoppingDatabase
import com.mvvm.grocerylist.data.db.entity.ShoppingItem
import org.koin.ext.getScopeId

class ShoppingRepository(
    private val database: ShoppingDatabase
) {

    suspend fun upsert(item: ShoppingItem) = database.getDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = database.getDao().delete(item)

    fun getAllShoppingItems () : LiveData<List<ShoppingItem>> = database.getDao().getAllShoppingItems()
}