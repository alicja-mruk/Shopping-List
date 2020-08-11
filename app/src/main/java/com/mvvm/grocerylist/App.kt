package com.mvvm.grocerylist

import android.app.Application
import com.mvvm.grocerylist.di.modules.databaseModule
import com.mvvm.grocerylist.di.modules.shoppingViewModel
import com.mvvm.grocerylist.di.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@App)
            modules(moduleList)
        }
    }
    private val moduleList = databaseModule + viewModelModule
}