package com.example.lobutuscodingtest.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBid (bidList: BidList) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRid (bidList: RidList) : Long

    @Query( "select * from tableRid ")
     fun getRid() : Flow<List<RidList>>

     @Query( "select * from tableBid ")
     fun getBid() : Flow<List<BidList>>

//    @Query("delete from products")
//     fun deleteAll()
}