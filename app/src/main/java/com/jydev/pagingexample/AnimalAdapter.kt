package com.jydev.pagingexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jydev.pagingexample.databinding.ItemAnimalBinding
import com.jydev.pagingexample.model.Animal

class AnimalAdapter : PagedListAdapter<Animal,AnimalAdapter.ViewHolder>(DIFF_CALLBACK) {
    inner class ViewHolder(private val binding : ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(animal : Animal?){
            binding.run {
                animalData = animal
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.item_animal,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        holder.bind(getItem(position))
    }


    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Animal>(){
            override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean =
                oldItem == newItem

            override fun getChangePayload(oldItem: Animal, newItem: Animal): Any? {
                return super.getChangePayload(oldItem, newItem)
            }
        }
    }
}