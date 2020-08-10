package com.mvvm.grocerylist.di.modules

import com.mvvm.grocerylist.data.db.database.ShoppingDatabase
import com.mvvm.grocerylist.data.repository.ShoppingRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import org.koin.experimental.builder.single


val roomModule = module {
    single { ShoppingDatabase.getDatabase(androidApplication()) }
    single { get<ShoppingDatabase>().getDao() }
}

val repositoryModule = module {
    single { ShoppingRepository(get()) }
}

val databaseModule = listOf(roomModule, repositoryModule)