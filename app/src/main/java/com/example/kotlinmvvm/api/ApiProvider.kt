package com.example.kotlinmvvm.api

class ApiProvider
{

    companion object{

         var apiService:ApiService ?= null
        fun apiProvider(): ApiService?
        {
            if (apiService==null){
                apiService=MyClient.getRetrofit()?.create(ApiService::class.java)
            }
            return apiService

        }
    }


}