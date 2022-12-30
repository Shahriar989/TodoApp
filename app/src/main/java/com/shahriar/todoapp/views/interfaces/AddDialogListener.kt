package com.shahriar.todoapp.views.interfaces

import com.shahriar.todoapp.data.offline.entities.ShoppingItem

interface AddDialogListener {

    fun addItemListener(item: ShoppingItem)
}