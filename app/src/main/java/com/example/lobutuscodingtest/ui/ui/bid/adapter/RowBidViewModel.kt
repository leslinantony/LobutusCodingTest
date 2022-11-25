package com.example.lobutuscodingtest.ui.ui.bid.adapter

import androidx.databinding.BaseObservable
import com.example.lobutuscodingtest.room.BidList

class RowBidViewModel(bidData: BidList) : BaseObservable() {

    var bid: String= ":  "+bidData.BID
    var name: String= ":  "+bidData.CustomerName
    var phone: String= ":  "+bidData.WorkOrderNo
    var village: String= ":  "+bidData.Village
    var adhar: String= ":  "+bidData.AdharNo
    var district: String= ":  "+bidData.District
    var state: String= ":  "+bidData.State

}