package com.example.lobutuscodingtest.ui.ui.rid.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lobutuscodingtest.R
import com.example.lobutuscodingtest.databinding.LayoutRowRidBinding
import com.example.lobutuscodingtest.room.RidList
import java.util.*

class RidAdapter: RecyclerView.Adapter<RidAdapter.ViewHolder>() {

    var ridList: List<RidList> = Collections.emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding: LayoutRowRidBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.layout_row_rid,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(ridList[position])
    }

    fun setData(data:List<RidList>)
    {
        this.ridList= data
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return ridList.size
    }
    class ViewHolder(val binding: LayoutRowRidBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(ridList: RidList) {
            binding.apply {
                this.viewModel= RowRidViewModel(ridList)
            }
        }

    }


}