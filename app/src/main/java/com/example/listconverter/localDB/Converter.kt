package com.example.listconverter.localDB

import androidx.room.TypeConverter
import com.example.listconverter.User
import com.google.gson.Gson

class Converter {
    private val gson = Gson()
// user is my own class
    @TypeConverter
    fun listToJsonString(value: List<User>): String? =
        if (value.isEmpty()) null else gson.toJson(value)
            // these are the functions we need to insert and retrieve data

    @TypeConverter
    fun jsonStringToList(value: String?): List<User>? {
        return if (value.isNullOrEmpty()) null else gson.fromJson(value, Array<User>::class.java)
            .toList()
    }


}
