package com.jydev.pagingexample.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

open class BaseViewModel : ViewModel(){
    inline fun <reified T> DataSource.Factory<Int,T>.toLiveData(config : Int) : LiveData<PagedList<T>> =
        LivePagedListBuilder(this,config).build()
}