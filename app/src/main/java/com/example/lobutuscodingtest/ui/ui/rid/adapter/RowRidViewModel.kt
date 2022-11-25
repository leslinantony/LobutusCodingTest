package com.example.lobutuscodingtest.ui.ui.rid.adapter

import androidx.databinding.BaseObservable
import com.example.lobutuscodingtest.room.RidList

class RowRidViewModel(ridList: RidList) : BaseObservable() {

    var RID: String= ":  "+ridList.RID
    var productSet: String= ":  "+ridList.ProjectCode
    var pump: String= ":  "+ridList.PumpHeadSrNo
    var motor: String= ":  "+ridList.MotorSerialNumber
    var controller: String= ":  "+ridList.ControllerItemCode


}