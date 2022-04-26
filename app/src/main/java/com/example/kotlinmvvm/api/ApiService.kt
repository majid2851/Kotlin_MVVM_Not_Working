package com.example.kotlinmvvm.api

import com.example.kotlinmvvm.model.MyModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService
{
    //
    @GET("us/33162")
    fun getInformation(): Single<MyModel>
}