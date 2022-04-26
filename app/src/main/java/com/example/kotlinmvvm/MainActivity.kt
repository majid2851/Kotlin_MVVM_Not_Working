package com.example.kotlinmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinmvvm.api.ApiProvider
import com.example.kotlinmvvm.api.ApiProvider.Companion.apiService
import com.example.kotlinmvvm.api.ApiService
import com.example.kotlinmvvm.api.MyClient
import com.example.kotlinmvvm.data.MyRepository
import com.example.kotlinmvvm.data.MyViewModel
import com.example.kotlinmvvm.model.MyModel
import com.example.kotlinmvvm.mydata.MainViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.time.Duration
import kotlin.math.log

class MainActivity : AppCompatActivity()
{
    private lateinit var myViewModel:MyViewModel
    private lateinit var repository: MyRepository
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv:TextView
        tv=findViewById(R.id.title)


         getDataMyWay(tv)

//        val apiService:ApiService= ApiProvider.apiProvider()!!
//        repository=MyRepository(apiService)
//        myViewModel=myViewModel()
//        myViewModel.getData.observe(this, Observer {
//            tv.setText(it.toString())
//            loging(it)
//        })
//
//        myViewModel.getNetworkState.observe(this, Observer {
//            tv.setText(it.toString())
//            Log.i("mag2851-error",it.toString())
//            //loging(it)
//        })




    }

    private fun getDataMyWay(tv: TextView)
    {
        mainViewModel().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    loging(it)
                    tv.setText(it.toString())
                },
                {
                    Log.i("mag2851-error", it.toString())
                    tv.setText(it.toString())
                }
            ).dispose()
    }

    private fun mainViewModel():MainViewModel{
        return ViewModelProvider(this).get(MainViewModel::class.java)
    }


    private fun myViewModel():MyViewModel{
        return ViewModelProvider(this).get(MyViewModel::class.java)
    }


    private fun loging(it: MyModel?) {
        Log.i("mag2851",it.toString())


    }




}