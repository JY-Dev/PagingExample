package com.jydev.pagingexample.data

import com.jydev.pagingexample.model.Animal

class AnimalDataSourceImpl(private val animalDao: AnimalDao) : DataSource<Animal> {
    override suspend fun insert(data: Animal) =
        animalDao.insert(data)

    override suspend fun delete(data: Animal) =
        animalDao.delete(data)

    override suspend fun update(data: Animal) =
        animalDao.update(data)

    override fun getAnimal(): androidx.paging.DataSource.Factory<Int,Animal> =
        animalDao.getAnimal()
}