package com.example.lobutuscodingtest.ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lobutuscodingtest.R
import com.example.lobutuscodingtest.databinding.FragmentHomeBinding
import com.example.lobutuscodingtest.ui.ui.bid.BidFragment
import com.example.lobutuscodingtest.ui.ui.rid.RidFragment


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragment(savedInstanceState, BidFragment())
        binding.layoutBid.setOnClickListener{
            setFragment(savedInstanceState,BidFragment())
        }

        binding.layoutRid.setOnClickListener{
            setFragment(savedInstanceState,RidFragment())
        }

    }

    private fun setFragment(savedInstanceState: Bundle?, fragment: Fragment) {
        if (savedInstanceState == null){
            childFragmentManager .beginTransaction()
                .replace(R.id.frame_layout,fragment ).commit();}
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}