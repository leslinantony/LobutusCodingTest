package com.example.lobutuscodingtest.ui.ui.bid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lobutuscodingtest.R
import com.example.lobutuscodingtest.databinding.LayoutRowBidBinding
import com.example.lobutuscodingtest.room.BidList
import java.util.Collections

class BidAdapter: RecyclerView.Adapter<BidAdapter.ViewHolder>() {

    var bidList: List<BidList> = Collections.emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding: LayoutRowBidBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.layout_row_bid,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(bidList[position])
    }

    fun setData(data:List<BidList>)
    {
        this.bidList= data
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return bidList.size
    }
    class ViewHolder(val binding: LayoutRowBidBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(bidList: BidList) {
            binding.apply {
                this.viewModel= RowBidViewModel(bidList)
            }
        }

    }


}