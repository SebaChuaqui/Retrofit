package com.example.retrofit

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.model.Repository
import com.example.retrofit.model.Terrain

class MarsViewModel: ViewModel() {
    private val repository = Repository()

    init{
        repository.getDataFromServer()
    }

    fun exposeLiveDataFromServer(): LiveData<List<Terrain>>{

        return repository.mLiveData

    }
}