package com.mvvm.grocerylist.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    var name: String,
    var currency: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}