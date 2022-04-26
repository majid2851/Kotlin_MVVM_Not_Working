package com.example.kotlinmvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinmvvm.api.ApiProvider
import com.example.kotlinmvvm.api.ApiProvider.Companion.apiService
import com.example.kotlinmvvm.model.MyModel
import io.reactivex.disposables.CompositeDisposable

public class MyViewModel(
    val repository: MyRepository
    ) : ViewModel()
{
    private val disposable=CompositeDisposable()

    val getData : LiveData<MyModel> by lazy {
        repository.getData(disposable)
    }

    val getNetworkState : LiveData<NetworkState> by lazy {
        repository.getNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}