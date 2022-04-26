package com.example.kotlinmvvm.mydata

import com.example.kotlinmvvm.model.MyModel
import io.reactivex.Single

interface DataSource
{
    fun getData():Single<MyModel>






}