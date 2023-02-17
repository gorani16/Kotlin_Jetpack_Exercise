package com.gorani.jetpack_exercise.ex_lifecycleowner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LifeCycleOwnerViewModel : ViewModel() {

    private val _countValue = MutableLiveData<Int>(0)
    var countValue: LiveData<Int> = _countValue

    fun plusCountValue() {
        _countValue.value = _countValue.value!!.plus(1)
    }

    fun minusCountValue() {
        _countValue.value = _countValue.value!!.minus(1)
    }

}