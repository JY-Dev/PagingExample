package com.jydev.pagingexample.data

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import androidx.room.*
import com.jydev.pagingexample.model.Animal

@Dao
interface AnimalDao {
    @Insert
    suspend fun insert(vararg animal: Animal)

    @Delete
    suspend fun delete(vararg animal: Animal)

    @Update
    suspend fun update(vararg animal: Animal)

    @Query("SELECT * FROM animal")
    fun getAnimal() : DataSource.Factory<Int,Animal>

}