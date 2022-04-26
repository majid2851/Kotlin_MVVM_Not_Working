package com.example.kotlinmvvm.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvm.api.ApiProvider
import com.example.kotlinmvvm.api.ApiService
import com.example.kotlinmvvm.model.MyModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.lang.Exception

class ApiDataSource(private val apiService: ApiService,
                    private val disposable:CompositeDisposable)
{
    private val mutableNetworkState=  MutableLiveData<NetworkState>()
    val networkState:LiveData<NetworkState> get() =  MutableLiveData<NetworkState>()

    private val mutableResponse = MutableLiveData<MyModel>()
    val response:LiveData<MyModel> get() = MutableLiveData<MyModel>()

    fun getData()
    {
        mutableNetworkState.postValue(NetworkState.LOADING)
        try {
           disposable.add(
               apiService.getInformation()
                   .subscribeOn(Schedulers.io())
                   .subscribe(
                       {
                           mutableNetworkState.postValue(NetworkState.LOADED)
                           mutableResponse.postValue(it)
                       },
                       {
                            mutableNetworkState.postValue(NetworkState.ERROR)
                           Log.i("mag2851","failed to connect")
                       }
                   )
           )

        }catch (e:Exception)
        {
            Log.i("mag2851",e.toString())

        }

    }


}


