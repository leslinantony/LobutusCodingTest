package com.example.lobutuscodingtest.ui.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun clickBid(view:View)
    {

    }

    fun clickBRid(view:View)
    {

    }


}