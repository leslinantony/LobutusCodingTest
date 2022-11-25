package com.example.lobutuscodingtest.ui.ui.rid

import android.annotation.SuppressLint
import androidx.annotation.WorkerThread
import com.example.lobutuscodingtest.retrofit.ApiInterface
import com.example.lobutuscodingtest.room.BidList
import com.example.lobutuscodingtest.room.Dao
import com.example.lobutuscodingtest.room.RidList
import com.example.lobutuscodingtest.ui.ui.bid.pojo.BID
import com.example.lobutuscodingtest.ui.ui.bid.pojo.BidResponse
import com.example.lobutuscodingtest.ui.ui.rid.pojo.RidResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody
import java.time.Year

class RidRepository constructor(
    private val dao: Dao,
    private val apiInterface: ApiInterface
)  {

    suspend fun getRid(api: ApiInterface?, body: RequestBody) = apiInterface?.getRid(body)

    fun getRidsFromCache(): Flow<List<RidList>> {
        return  dao.getRid()
    }

    @SuppressLint("SuspiciousIndentation")
    @SuppressWarnings
    @WorkerThread
    suspend fun insertRid(response: RidResponse?)
    {
        if (response != null) {
            for (rid in response.data){

                var p= RidList(


                    AssignedToID=rid.AssignedToID,
                    AssignedToName=rid.AssignedToName,
                    ControllerItemCode=rid.ControllerItemCode,
                    ControllerItemCodeDesc=rid.ControllerItemCodeDesc,
                    ControllerSerialNumber=rid.ControllerSerialNumber,
                    CustomerName=rid.CustomerName,
                    HP=rid.HP,
                    Head=rid.Head,
                    ID=rid.ID,
                    InstallationID=rid.InstallationID,
                    MotorItemCode=rid.MotorItemCode,
                    MotorItemCodeDesc=rid.MotorItemCodeDesc,
                    MotorSerialNumber=rid.MotorSerialNumber,
                    ProjectCode=rid.ProjectCode,
                    ProjectID=rid.ProjectID,
                    ProjectName=rid.ProjectName,
                    PumpHeadItemCode=rid.PumpHeadItemCode,
                    PumpHeadItemCodeDesc=rid.PumpHeadItemCodeDesc,
                    PumpHeadSrNo=rid.PumpHeadSrNo,
                    PumpSetItemCode=rid.PumpSetItemCode,
                    PumpSetItemCodeDesc=rid.PumpSetItemCodeDesc,
                    RID=rid.RID,
                    RID_InvoiceDate=rid.RID_InvoiceDate,
                    RID_InvoiceNo=rid.RID_InvoiceNo,
                    RID_PumpHeadType=rid.RID_PumpHeadType,
                    RID_PumpType=rid.RID_PumpType,
                    SubInstaller=rid.SubInstaller,
                    Year=rid.Year,
                )

                dao.insertRid(p)
            }
        }}

}