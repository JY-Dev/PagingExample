package com.jydev.pagingexample.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jydev.pagingexample.model.Animal

@Database(entities = [Animal::class], version = 1)
abstract class AnimalDB : RoomDatabase() {
    abstract fun getDao() : AnimalDao
    object Factory{
        private const val dbName = "animal.db"
        fun create(context: Context) : AnimalDB =
            Room.databaseBuilder(
                context.applicationContext,
                AnimalDB::class.java,
                dbName).build()
    }
}