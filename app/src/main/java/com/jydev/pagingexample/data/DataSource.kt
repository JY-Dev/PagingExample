package com.jydev.pagingexample.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList

interface DataSource<T> {
    suspend fun insert(data: T)
    suspend fun delete(data: T)
    suspend fun update(data: T)
    fun getAnimal() : DataSource.Factory<Int,T>

}