package com.mvvm.grocerylist.ui

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.grocerylist.R
import com.mvvm.grocerylist.data.db.entity.ShoppingItem
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.mvvm.grocerylist.databinding.FragmentShoppingBinding
import com.mvvm.grocerylist.ui.adapter.ShoppingListAdapter
import com.mvvm.grocerylist.utils.toast

class ShoppingFragment : Fragment() {
    private lateinit var binding: FragmentShoppingBinding
    private lateinit var adapter: ShoppingListAdapter
    private val viewModel: ShoppingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShoppingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()

    }

    fun onFabButtonCLicked() {
        createAddItemDialog()
    }

    private fun initView(){
        setRecyclerView()
        setAdapter()
    }

    private fun setAdapter() {
        adapter = ShoppingListAdapter(viewModel)
        binding.recyclerView.adapter = adapter

        adapter.onAddItemClick = {
            viewModel.upsert(it)
            adapter.updateAdapterList()
        }

        adapter.onRemoveItemClick = {
            viewModel.delete(it)
            adapter.updateAdapterList()
        }
    }

    private fun setRecyclerView(){
        val linearLayoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = linearLayoutManager
    }

    private fun createAddItemDialog() {
        val view: View = layoutInflater.inflate(R.layout.dialog_add_item, null)
        val alertDialog = context?.let { AlertDialog.Builder(it).create() }
        alertDialog?.setTitle(context?.resources?.getString(R.string.add_product))
        alertDialog?.setCancelable(false)

        val productNameEditText = view.findViewById(R.id.product_name_edittext) as EditText
        val productCurrencyEditText = view.findViewById(R.id.product_currency_edittext) as EditText

        alertDialog?.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
            DialogInterface.OnClickListener { _, _ ->
                val newShoppingItem =
                    ShoppingItem(productNameEditText.toString(), productCurrencyEditText.toString())
                viewModel.upsert(newShoppingItem)
                adapter.updateAdapterList()
                alertDialog.dismiss()
            })

        alertDialog?.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel",
            DialogInterface.OnClickListener { _, _ ->
                context?.let {
                    it.resources?.getString(R.string.cancelled)?.toast(it)
                    alertDialog.dismiss()
                }
            })

        alertDialog?.setView(view);
        alertDialog?.show()
    }


}