package com.example.kotlinmvvm.data

enum class Status{
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status:Status,val msg:String)
{
    companion object{
        val LOADED:NetworkState
        val LOADING:NetworkState
        val ERROR:NetworkState

        init {
            LOADED=NetworkState(Status.SUCCESS,"successful")
            LOADING=NetworkState(Status.RUNNING,"its running")
            ERROR= NetworkState(Status.FAILED,"something wrong c")
        }

    }





}