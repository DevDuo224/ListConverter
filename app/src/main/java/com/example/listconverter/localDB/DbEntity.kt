package com.example.listconverter.localDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.listconverter.User

@Entity(tableName = "users_table") // this is my entity let's jump into type converter
data class DbEntity(
    @PrimaryKey(autoGenerate = true)
    val sid: Int = 0,

    @ColumnInfo(name = "userList")
    val userList:List<User>?
)