package com.mvvm.grocerylist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mvvm.grocerylist.data.db.entity.ShoppingItem
import com.mvvm.grocerylist.data.repository.ShoppingRepository
import com.mvvm.grocerylist.state.LoadingState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {
    var shoppingItems = MutableLiveData<List<ShoppingItem>>()

    init {
        shoppingItems.value = getAllShoppingItems()
    }

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()

}