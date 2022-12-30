package com.shahriar.todoapp.views.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.shahriar.todoapp.data.offline.db.ShoppingDatabase
import com.shahriar.todoapp.data.offline.entities.ShoppingItem
import com.shahriar.todoapp.databinding.ActivityMainBinding
import com.shahriar.todoapp.viewmodels.ShoppingViewModel
import com.shahriar.todoapp.views.adapters.ShoppingAdapter
import com.shahriar.todoapp.views.interfaces.AddDialogListener
import com.shahriar.todoapp.views.utils.ShoppingItemDialog

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var viewModel: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addItemBtn.setOnClickListener {

            openDialogBox()
        }
        viewModel = ViewModelProvider(this)[ShoppingViewModel::class.java]
        viewModel.getAllItem().observe(this){

            val dataList: List<ShoppingItem> = it
            var adapter: ShoppingAdapter = ShoppingAdapter(this, dataList)
            binding.itemRecyclerView.adapter = adapter
            binding.itemRecyclerView.setHasFixedSize(true)
        }
    }

    private fun openDialogBox() {
        ShoppingItemDialog(this,
            object : AddDialogListener {
                override fun addItemListener(item: ShoppingItem) {
                    viewModel.insertItem(item)
                }
            }
        ).show()
    }
}