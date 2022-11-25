package com.example.lobutuscodingtest.ui.ui.rid

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lobutuscodingtest.retrofit.ApiInterface
import com.example.lobutuscodingtest.room.BidList
import com.example.lobutuscodingtest.room.RidList
import kotlinx.coroutines.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import org.json.JSONObject
import java.lang.Exception

class RidViewModel(application: Application) : AndroidViewModel(application) {

    val errorMessage = MutableLiveData<String>()
    var ridList = MutableLiveData<List<RidList>>()
    var job: Job? = null

    val loading = MutableLiveData<Boolean>()

    val repository = (application as com.example.lobutuscodingtest.Application).ridRepository


    fun getRid() {
        job = CoroutineScope(Dispatchers.IO).launch {
            val jsonParams: MutableMap<String?, Any?> = HashMap()
            jsonParams["UserID"] = "2"
            jsonParams["CustomerTypeID"] = "7"


            val body = RequestBody.create(
                "application/json; charset=utf-8".toMediaTypeOrNull(),
                JSONObject(jsonParams).toString()
            )


            val response =
                repository.getRid(ApiInterface.RetrofitClient.getInstance(), body)
            withContext(Dispatchers.Main) {
                try {
                    if (response != null) {
                        if (response.isSuccessful) {
                            repository?.insertRid(response.body())
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

    fun getBidsFromCache(): LiveData<List<RidList>> {
        CoroutineScope(Dispatchers.Main).launch {
            if (repository != null) {

                var response = repository.getRidsFromCache()
                response.collect {
                    ridList.value = it
                }
            }
        }
        return ridList
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