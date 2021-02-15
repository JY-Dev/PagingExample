package com.jydev.pagingexample.di


import com.jydev.pagingexample.data.AnimalDB
import com.jydev.pagingexample.data.AnimalDataSourceImpl
import org.koin.dsl.module

val roomModule = module {
    single {
        AnimalDataSourceImpl(
            AnimalDB.Factory.create(
                get()
            ).getDao()
        )
    }
}