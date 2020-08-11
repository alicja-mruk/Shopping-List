package com.mvvm.grocerylist.di.modules

import androidx.room.Room
import com.mvvm.grocerylist.data.db.dao.ShoppingDao
import com.mvvm.grocerylist.data.db.database.ShoppingDatabase
import com.mvvm.grocerylist.data.repository.ShoppingRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.koinApplication
import org.koin.dsl.module
import org.koin.experimental.builder.single


val roomModule = module{
    single {
        Room.databaseBuilder(androidApplication(), ShoppingDatabase::class.java, "ShoppingDatabase.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<ShoppingDatabase>().getDao() }
}

val repositoryModule = module {
    single { ShoppingRepository(get()) }
}

val databaseModule = listOf(repositoryModule, roomModule)