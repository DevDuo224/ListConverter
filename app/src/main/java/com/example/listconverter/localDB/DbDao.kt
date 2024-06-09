package com.example.listconverter.localDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DbDao {
    @Insert
    suspend fun insertSignupDetails(dbEntity: DbEntity)

    @Query("select * from users_table")
    fun getAllContactsDetails(): List<DbEntity>


}