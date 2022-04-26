package com.example.kotlinmvvm.data

import androidx.lifecycle.LiveData
import com.example.kotlinmvvm.api.ApiService
import com.example.kotlinmvvm.model.MyModel
import io.reactivex.disposables.CompositeDisposable

class MyRepository(private val apiService: ApiService)
{
    lateinit var apiDataSource: ApiDataSource

    fun getData( disposable: CompositeDisposable):LiveData<MyModel>
    {
         apiDataSource= ApiDataSource(apiService,disposable)

         apiDataSource.getData()
         return apiDataSource.response
    }

    fun getNetworkState():LiveData<NetworkState>
    {
        return apiDataSource.networkState
    }










}