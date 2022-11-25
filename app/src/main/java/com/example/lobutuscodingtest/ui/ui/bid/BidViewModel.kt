package com.example.lobutuscodingtest.ui.ui.bid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lobutuscodingtest.retrofit.ApiInterface
import com.example.lobutuscodingtest.room.BidList
import com.example.lobutuscodingtest.room.ProductList
import kotlinx.coroutines.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import java.lang.Exception

class BidViewModel(application: Application) : AndroidViewModel(application) {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    val errorMessage = MutableLiveData<String>()
    var bidList = MutableLiveData<List<BidList>>()
    var job: Job? = null

    val loading = MutableLiveData<Boolean>()

    val repository = (application as com.example.lobutuscodingtest.Application).bidRepository


    fun getBid() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val jsonParams: MutableMap<String?, Any?> = HashMap()
            jsonParams["UserID"] = "2"
            jsonParams["CustomerTypeID"] = "7"


            val body = RequestBody.create(
                "application/json; charset=utf-8".toMediaTypeOrNull(),
                JSONObject(jsonParams).toString()
            )


                val response =
                    repository.getBid(ApiInterface.RetrofitClient.getInstance(), body)
                withContext(Dispatchers.Main) {

                    try {


                    if (response != null) {
                        if (response.isSuccessful) {
                            repository?.insertBid(response.body())
                            //Toast.makeText(getApplication(), response.body().toString(), Toast.LENGTH_SHORT).show()
                            loading.value = false
                        } else {
                            onError("Error : ${response.message()} ")
                        }
                    }
                    } catch (e: Exception) {
                        onError("Error : ${e.message} ")
                    }
                }


        }


    }

    fun getBidsFromCache(): LiveData<List<BidList>> {
        CoroutineScope(Dispatchers.Main).launch {
            if (repository != null) {

                var response = repository.getBidsFromCache()
                response.collect{
                    bidList.value= it
                }
            }
        }
        return bidList
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}