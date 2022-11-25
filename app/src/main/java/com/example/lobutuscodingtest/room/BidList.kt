package com.example.lobutuscodingtest.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableBid")
class BidList
    (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "BID_ID")
    var BID_ID: String,


    @ColumnInfo(name = "AdharNo")
    var AdharNo: String,

    @ColumnInfo(name = "AssignedToName")
    var AssignedToName: String,

    @ColumnInfo(name = "BID")
    var BID: String,

    @ColumnInfo(name = "FarmerID")
    var FarmerID: Int,

    @ColumnInfo(name = "Cities_IDPK")
    var Cities_IDPK: String,

    @ColumnInfo(name = "City")
    var City: String,

    @ColumnInfo(name = "CustomerName")
    var CustomerName: String,

    @ColumnInfo(name = "CustomerType")
    var CustomerType: String,

    @ColumnInfo(name = "District")
    var District: String,

    @ColumnInfo(name = "Districts_IDPK")
    var Districts_IDPK: String,

    @ColumnInfo(name = "Farmer_InstallerId")
    var Farmer_InstallerId: String,

    @ColumnInfo(name = "Farmer_SubInstaller")
    var Farmer_SubInstaller: String,

    @ColumnInfo(name = "Mobile")
    var Mobile: Long,

    @ColumnInfo(name = "Pincode")
    var Pincode: Int,

    @ColumnInfo(name = "ProjectCode")
    var ProjectCode: String,

    @ColumnInfo(name = "ProjectName")
    var ProjectName: String,

    @ColumnInfo(name = "State")
    var State: String,

    @ColumnInfo(name = "States_IDPK")
    var States_IDPK: String,

    @ColumnInfo(name = "Status")
    var Status: String,

    @ColumnInfo(name = "Taluka")
    var Taluka: String,

    @ColumnInfo(name = "Village")
    var Village: String,

    @ColumnInfo(name = "WaterSource")
    var WaterSource: String,

    @ColumnInfo(name = "WorkOrderNo")
    var WorkOrderNo: String

            ){


}