package com.example.lobutuscodingtest

import com.example.lobutuscodingtest.retrofit.ApiInterface
import com.example.lobutuscodingtest.room.DataBase
import com.example.lobutuscodingtest.ui.ui.bid.BidRepository
import com.example.lobutuscodingtest.ui.ui.rid.RidRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class Application : android.app.Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { DataBase.getDataBase(this, applicationScope) }
    val bidRepository by lazy { BidRepository(database.getDao(), ApiInterface.RetrofitClient.getInstance())  }
    val ridRepository by lazy { RidRepository(database.getDao(), ApiInterface.RetrofitClient.getInstance())  }

}