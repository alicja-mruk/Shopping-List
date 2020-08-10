package com.mvvm.grocerylist.di.modules

import androidx.room.RoomDatabase
import com.mvvm.grocerylist.data.db.database.ShoppingDatabase
import com.mvvm.grocerylist.data.repository.ShoppingRepository
import com.mvvm.grocerylist.ui.ShoppingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val shoppingViewModel = module{
    viewModel {
        ShoppingViewModel(get())
    }
}

val viewModelModule = listOf(shoppingViewModel)