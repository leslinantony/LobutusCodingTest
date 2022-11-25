package com.example.lobutuscodingtest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
@Database(entities = [BidList::class, RidList::class], version = 1)
abstract class DataBase: RoomDatabase() {

    abstract fun getDao(): Dao


    companion object {

        @Volatile
        private var INSTANCE: DataBase? = null


        fun getDataBase(context: Context, scope: CoroutineScope): DataBase {
            return INSTANCE ?: synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java, "database"
                )
                        .addCallback(ProductDatabaseCallBack(scope))
                    .build()

                INSTANCE = instance
                instance
            }
        }


    }

    private class ProductDatabaseCallBack(val scope: CoroutineScope) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE.let { database ->
                scope.launch {
                    if (database != null) {

                    }
                }
            }
        }


    }
}

