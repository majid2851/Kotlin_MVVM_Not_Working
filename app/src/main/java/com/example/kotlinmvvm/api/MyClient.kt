package com.example.kotlinmvvm.api

import android.content.Context
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val api_key=""
const val base_url="https://api.zippopotam.us/"


 var retrofit: Retrofit? = null

class MyClient()
{
    companion object{
        fun getRetrofit(): Retrofit?
        {
            if(retrofit==null)
            {

                retrofit= Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(base_url)
                    .build();
            }

            return  retrofit
        }


    }



}