package com.example.firebasevsmvvm.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firebasevsmvvm.model.ComputersModel
import com.example.firebasevsmvvm.repository.ComputersRepository

class ComputersViewModel: ViewModel() {

    private val repository = ComputersRepository()

    fun getMutableList(): MutableLiveData<List<ComputersModel>> {
        return repository.getMutableLiveData()
    }
}