package com.jydev.pagingexample.binding

import android.widget.Button
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jydev.pagingexample.AnimalAdapter

@BindingAdapter("bind:animalAdapter")
fun setAnimalAdapter(view: RecyclerView, adapter: AnimalAdapter) {
    view.adapter = adapter
}

@BindingAdapter("bind:itemDecoration")
fun setItemDecoration(view : RecyclerView, itemDecoration: RecyclerView.ItemDecoration){
    view.addItemDecoration(itemDecoration)
}
