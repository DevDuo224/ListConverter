package com.example.listconverter

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listconverter.localDB.DbEntity
import com.example.listconverter.localDB.LocalDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(mContext:Context):ViewModel() {

    private val dbDao = LocalDB.getInstance(context = mContext).dbDao


    fun insertData(){
        viewModelScope.launch {
            dbDao.insertSignupDetails(dbEntity =
            DbEntity(
                userList = arrayListOf(
                    User(
                        name = "Rio",
                        age = 20
                    ), User(
                        name = "Raj",
                        age = 25
                    ),
                )
            )
            )
        }
    }

    fun getListData(){
        viewModelScope.launch {
            val list = dbDao.getAllContactsDetails()
            Log.i("list", list.toString())
        }
    }

}