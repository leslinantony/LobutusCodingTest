package com.example.lobutuscodingtest.ui.ui.bid

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lobutuscodingtest.databinding.FragmentBidBinding
import com.example.lobutuscodingtest.ui.ui.bid.adapter.BidAdapter


class BidFragment : Fragment() {

    private var _binding: FragmentBidBinding? = null
    lateinit var viewModel: BidViewModel
    lateinit var adapter: BidAdapter


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this).get(BidViewModel::class.java)

        _binding = FragmentBidBinding.inflate(inflater, container, false)
        val root: View = binding.root


        setupObservers(binding.rvBidList)

        return root
    }

    private fun setupObservers(rvBidList: RecyclerView) {

        rvBidList.setHasFixedSize(true)
        rvBidList.layoutManager= LinearLayoutManager(view?.context)
        adapter= BidAdapter()
        rvBidList.adapter=adapter

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBid()

        viewModel.getBidsFromCache().observe(viewLifecycleOwner, Observer {

            adapter.setData(it)
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            showLoading(it)
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showLoading(isLoading: Boolean)
    {
        if (isLoading){

            binding.progressBar.visibility=View.VISIBLE
        }else
        {
            binding.progressBar.visibility=View.GONE
        }
    }
}