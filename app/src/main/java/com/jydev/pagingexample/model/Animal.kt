package com.jydev.pagingexample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Animal(var name : String , var feed : String){
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}