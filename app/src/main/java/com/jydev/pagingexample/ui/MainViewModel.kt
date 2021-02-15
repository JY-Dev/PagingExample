package com.jydev.pagingexample.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.jydev.pagingexample.base.BaseViewModel
import com.jydev.pagingexample.data.AnimalDataSourceImpl
import com.jydev.pagingexample.model.Animal
import kotlinx.coroutines.launch

class MainViewModel(private val dataSource: AnimalDataSourceImpl) : BaseViewModel() {
    val animalName = MutableLiveData<String>().apply {
        value = "개"
    }
    val animalFeed = MutableLiveData<String>().apply {
        value = "개사료"
    }
    val animalDataSource : DataSource.Factory<Int,Animal> = dataSource.getAnimal()
    val animalList : LiveData<PagedList<Animal>> = animalDataSource.toLiveData(10)

    fun insert(){
        val name = animalName.getNonNull()
        val feed = animalFeed.getNonNull()
        val animal = Animal(name,feed)
        if(name.isEmpty()||feed.isEmpty())
            Log.d("Insert","IsEmpty")
        else{
            insertAnimal(animal)
            Log.d("Insert","Success")
        }

    }

    fun MutableLiveData<String>.getNonNull() : String = value?:""

    fun insertAnimal(animal: Animal){
        viewModelScope.launch {
            dataSource.insert(animal)
        }
    }



}