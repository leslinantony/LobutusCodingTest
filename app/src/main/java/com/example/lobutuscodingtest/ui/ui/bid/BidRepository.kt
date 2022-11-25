package com.example.lobutuscodingtest.ui.ui.bid

import android.annotation.SuppressLint
import androidx.annotation.WorkerThread
import com.example.lobutuscodingtest.retrofit.ApiInterface
import com.example.lobutuscodingtest.room.BidList
import com.example.lobutuscodingtest.room.Dao
import com.example.lobutuscodingtest.room.ProductList
import com.example.lobutuscodingtest.ui.ui.bid.pojo.BidResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody

class BidRepository
constructor(
    private val dao: Dao,
    private val apiInterface: ApiInterface
) {

    suspend fun getBid(api: ApiInterface?, body: RequestBody) = apiInterface?.getBid(body)

    fun getBidsFromCache(): Flow<List<BidList>> {
        return  dao.getBid()
    }

    @SuppressLint("SuspiciousIndentation")
    @SuppressWarnings
    @WorkerThread
    suspend fun insertBid(response: BidResponse?)
    {
        if (response != null) {
            for (bid in response.BID){

                var p= BidList(

                    AdharNo=bid.AdharNo,
                    AssignedToName=bid.AssignedToName,
                    BID=bid.BID,
                    BID_ID=bid.BID_ID,
                    Cities_IDPK=bid.Cities_IDPK,
                    City=bid.City,
                    CustomerName=bid.CustomerName,
                    CustomerType=bid.CustomerType,
                    District=bid.District,
                    Districts_IDPK=bid.Districts_IDPK,
                    FarmerID= bid.FarmerID,
                    Farmer_InstallerId=bid.Farmer_InstallerId,
                    Farmer_SubInstaller=bid.Farmer_SubInstaller,
                    Mobile=bid.Mobile,
                    Pincode=bid.Pincode,
                    ProjectCode=bid.ProjectCode,
                    ProjectName=bid.ProjectName,
                    State=bid.State,
                    States_IDPK=bid.States_IDPK,
                    Status=bid.Status,
                    Taluka=bid.Taluka,
                    Village=bid.Village,
                    WaterSource=bid.WaterSource,
                    WorkOrderNo=bid.WorkOrderNo
                )

                dao.insertBid(p)
            }
        }}
}