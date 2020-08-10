package com.mvvm.grocerylist.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.grocerylist.data.db.entity.ShoppingItem

class ShoppingItemAdapter (
private val items : List<ShoppingItem>
)  :  RecyclerView.Adapter<ShoppingItemAdapter.ShoppingItemHolder>() {


    inner class ShoppingItemHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ShoppingItemHolder, position: Int) {
        TODO("Not yet implemented")
    }
}