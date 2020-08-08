package com.mvvm.grocerylist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mvvm.grocerylist.databinding.ActivityShoppingBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShoppingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}