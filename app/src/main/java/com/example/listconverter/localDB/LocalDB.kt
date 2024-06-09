package com.example.listconverter.localDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Database(entities = [DbEntity::class], version = 11)
@TypeConverters(Converter::class) //add this to automatically parse your values as string and then back to list
abstract class LocalDB:RoomDatabase() {
    abstract val dbDao: DbDao

    companion object {
        @Volatile
        private var INSTANCE: LocalDB?=null

        fun getInstance(context: Context): LocalDB {
            synchronized(this){
                var tempInstance = INSTANCE
                if (tempInstance==null){
                    tempInstance= Room.databaseBuilder(
                        context.applicationContext,
                        LocalDB::class.java,
                        "Users_Database"
                    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                }

                INSTANCE = tempInstance

                return tempInstance
            }
        }
    }
}


//fun getInstance(context: Context): LocalDB {
//    synchronized(this){
//        return LocalDB.instance ?:Room.databaseBuilder(
//            context = context.applicationContext,
//            klass = LocalDB::class.java,
//            name = "Registration_Database"
//        ).allowMainThreadQueries().fallbackToDestructiveMigration().build().also {
//            LocalDB.instance = it
//        }
//    }
//}