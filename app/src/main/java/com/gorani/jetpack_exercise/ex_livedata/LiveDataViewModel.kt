package com.gorani.jetpack_exercise.ex_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * LiveData vs MutableLiveData
 * 이 둘을 구분짓는 이유 : Encapsulation (캡슐화) 목적임. LiveData 를 외부에서 변경하지 못하도록 하기 위함.
 * - MutableLiveData : 변경이 가능하지만 외부로 부터 접근이 불가능하다. _를 사용하는 네이밍 컨벤션이 존재한다.
 * - LiveData : 오직 읽기 전용(외부 공개용)으로 사용한다. MutableLiveData 값을 할당 받아서 LiveData 타입 변경 후 Activity or Fragment 에 반영한다.
 * ㄴ> LiveData 선언 시 반드시 타입을 명시 (LiveData) 를 해줘야한다. 그렇지 않으면 외부(Activity, Fragment) 에서 값이 변경 가능하다.
 */

class LiveDataViewModel : ViewModel() {

    private var _mutableLiveDataValue = MutableLiveData(0)
    val liveDataValue: LiveData<Int> = _mutableLiveDataValue

    fun plusLiveDataValue() {
        _mutableLiveDataValue.value = _mutableLiveDataValue.value!!.plus(1)
    }

    fun minusLiveDataValue() {
        _mutableLiveDataValue.value = _mutableLiveDataValue.value!!.minus(1)
    }

}