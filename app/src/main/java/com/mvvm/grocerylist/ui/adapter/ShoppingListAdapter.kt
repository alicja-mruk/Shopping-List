package com.mvvm.grocerylist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.grocerylist.R
import com.mvvm.grocerylist.data.db.entity.ShoppingItem
import com.mvvm.grocerylist.ui.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingListAdapter (private val viewModel: ShoppingViewModel):
    RecyclerView.Adapter<ShoppingListAdapter.ShoppingItemViewHolder>() {


    private var items : List<ShoppingItem>? = viewModel.getAllShoppingItems().value

    var onAddItemClick: ((ShoppingItem) -> Unit)? = null
    var onRemoveItemClick: ((ShoppingItem) -> Unit)? = null

    fun updateAdapterList(list : List<ShoppingItem>) {
        items = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ShoppingItemViewHolder(inflater.inflate(R.layout.shopping_item, parent, false))
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        items?.get(position).let {
            if (it != null) {
                holder.bindData(it)
            }
        }
    }

    inner class ShoppingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.add_product_btn.setOnClickListener {
                items?.get(adapterPosition).let { itemAdd ->
                    if (itemAdd != null) {
                        onAddItemClick?.invoke(itemAdd)
                    }
                }
            }

            itemView.remove_product_btn.setOnClickListener {
                items?.get(adapterPosition)
                    .let { itemRemove ->
                        if (itemRemove != null) {
                            onRemoveItemClick?.invoke(itemRemove)
                        }
                    }
            }
        }

        fun bindData(item: ShoppingItem) {
            itemView.product_name.text = item.name
            itemView.product_currency.text = item.currency.toString()
        }

    }


}