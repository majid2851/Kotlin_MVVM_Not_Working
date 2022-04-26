package com.example.kotlinmvvm.mydata

import com.example.kotlinmvvm.api.ApiProvider
import com.example.kotlinmvvm.api.ApiService
import com.example.kotlinmvvm.model.MyModel
import io.reactivex.Single

class ApiDataSource : DataSource
{

    override fun getData(): Single<MyModel> {
        return ApiProvider.apiProvider()!!.getInformation()
    }

}