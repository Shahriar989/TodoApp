package com.shahriar.todoapp.views.utils

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialog
import com.shahriar.todoapp.R
import com.shahriar.todoapp.data.offline.entities.ShoppingItem
import com.shahriar.todoapp.databinding.DialogShoppingBinding
import com.shahriar.todoapp.views.interfaces.AddDialogListener

class ShoppingItemDialog(
    context: Context,
    var addDialogListener: AddDialogListener
) : AppCompatDialog(context) {

    lateinit var btn_save: Button
    lateinit var btn_cancel: Button
    lateinit var et_Name: EditText
    lateinit var et_Amount: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_shopping)

        btn_save = findViewById(R.id.btn_save)!!
        btn_cancel = findViewById(R.id.btn_cancel)!!
        et_Name = findViewById(R.id.et_Name)!!
        et_Amount = findViewById(R.id.et_Amount)!!

        btn_save.setOnClickListener {

            val name = et_Name.text.toString().trim()
            val amount = et_Amount.text.toString().trim()

            val item: ShoppingItem = ShoppingItem(name, amount.toInt())
            addDialogListener.addItemListener(item)
        }

        btn_cancel.setOnClickListener {

            dismiss()
        }
    }
}