package com.example.lobutuscodingtest.retrofit

import com.example.lobutuscodingtest.ui.ui.bid.pojo.BidResponse
import com.example.lobutuscodingtest.ui.ui.rid.pojo.RidResponse
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {


    @POST("PostOemOrBidDetails")
    suspend fun getBid(@Body body: RequestBody?): Response<BidResponse>

    @POST("PostRidDetails")
    suspend fun getRid(@Body body: RequestBody?): Response<RidResponse>

    class RetrofitClient {

        companion object {
            var retrofitService: ApiInterface? = null
            fun getInstance() : ApiInterface {
                if (retrofitService == null) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://betaphase.in/rotomag/api/Installations/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    retrofitService = retrofit.create(ApiInterface::class.java)
                }
                return retrofitService!!
            }

        }
    }
}