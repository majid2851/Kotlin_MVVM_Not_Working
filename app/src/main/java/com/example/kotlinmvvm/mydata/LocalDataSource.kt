package com.example.kotlinmvvm.mydata

import com.example.kotlinmvvm.model.MyModel
import io.reactivex.Single

class LocalDataSource : DataSource
{
    override fun getData(): Single<MyModel> {
        TODO("Not yet implemented")
    }


}