package com.example.lobutuscodingtest.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableRid")
data class RidList(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "ID")
    var ID: Int,

    @ColumnInfo(name ="AssignedToID")
    var AssignedToID: String,

    @ColumnInfo(name ="AssignedToName")
    var AssignedToName: String,

    @ColumnInfo(name ="ControllerItemCode")
    var ControllerItemCode: String,

    @ColumnInfo(name ="ControllerItemCodeDesc")
    var ControllerItemCodeDesc: String,

    @ColumnInfo(name ="ControllerSerialNumber")
    var ControllerSerialNumber: String,

    @ColumnInfo(name ="TiCustomerNametle")
    var CustomerName: String,

    @ColumnInfo(name ="HP")
    var HP: String,

    @ColumnInfo(name ="Head")
    var Head: String,

    @ColumnInfo(name ="InstallationID")
    var InstallationID: Int,

    @ColumnInfo(name ="MotorItemCode")
    var MotorItemCode: String,

    @ColumnInfo(name ="MotorItemCodeDesc")
    var MotorItemCodeDesc: String,

    @ColumnInfo(name ="MotorSerialNumber")
    var MotorSerialNumber: String,

    @ColumnInfo(name ="ProjectCode")
    var ProjectCode: String,

    @ColumnInfo(name ="ProjectID")
    var ProjectID: String,

    @ColumnInfo(name ="ProjectName")
    var ProjectName: String,

    @ColumnInfo(name ="PumpHeadItemCode")
    var PumpHeadItemCode: String,

    @ColumnInfo(name ="PumpHeadItemCodeDesc")
    var PumpHeadItemCodeDesc: String,

    @ColumnInfo(name ="PumpHeadSrNo")
    var PumpHeadSrNo: String,

    @ColumnInfo(name ="PumpSetItemCode")
    var PumpSetItemCode: String,

    @ColumnInfo(name ="PumpSetItemCodeDesc")
    var PumpSetItemCodeDesc: String,

    @ColumnInfo(name ="RID")
    var RID: String,

    @ColumnInfo(name ="RID_InvoiceDate")
    var RID_InvoiceDate: String,

    @ColumnInfo(name ="RID_InvoiceNo")
    var RID_InvoiceNo: String,

    @ColumnInfo(name ="RID_PumpHeadType")
    var RID_PumpHeadType: String,

    @ColumnInfo(name ="RID_PumpType")
    var RID_PumpType: String,

    @ColumnInfo(name ="SubInstaller")
    var SubInstaller: String,

    @ColumnInfo(name ="Year")
    var Year: String
)
