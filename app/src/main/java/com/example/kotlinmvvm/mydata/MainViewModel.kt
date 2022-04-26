package com.example.kotlinmvvm.mydata

import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.model.MyModel
import io.reactivex.Single

class MainViewModel :ViewModel()
{
    private val apiDataSource=ApiDataSource()
    fun getData():Single<MyModel>
    {
        return apiDataSource.getData()
    }







}