package com.example.lobutuscodingtest.ui.ui.rid

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lobutuscodingtest.databinding.FragmentRidBinding
import com.example.lobutuscodingtest.ui.ui.rid.adapter.RidAdapter


class RidFragment : Fragment() {

    private var _binding: FragmentRidBinding? = null
    lateinit var adapter: RidAdapter
    lateinit var viewModel: RidViewModel

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         viewModel =
            ViewModelProvider(this).get(RidViewModel::class.java)


        _binding = FragmentRidBinding.inflate(inflater, container, false)
        val root: View = binding.root
        setupObservers(binding.rvRid)

        return root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRid()

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



    private fun setupObservers(rvRidList: RecyclerView) {

        rvRidList.setHasFixedSize(true)
        rvRidList.layoutManager= LinearLayoutManager(view?.context)
        adapter= RidAdapter()
        rvRidList.adapter=adapter

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