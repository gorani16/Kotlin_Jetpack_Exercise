package com.gorani.jetpack_exercise.ex_viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * ViewModel 에서 아래와 같이 변수 하나만 만들어서 사용하지는 않고
 * LiveData (+etc) 와 함께 사용한다.
 */

class ActivityViewModel(private val num: Int) : ViewModel() {

    private var countValue: Int = 0

    init {
        Log.d("ActivityViewModel", num.toString())
    }

    /**
     * 일반적으로 비즈니스 로직은 Data Layer 에 있지만 UI Layer 에도 비즈니스 로직이 포함될 수 있다.
     * ViewModel 에 포함되는 그 로직은 서버 또는 DB 로 부터 데이터를 ViewModel 로 받아오는 로직이다.
     * 데이터를 처리하는 로직을 구현해야하는 경우는 아래와 같이 두 가지로 구분된다.
     * 1. 네트워크 통신을 할 때, 즉 서버로부터 데이터를 가져올 때 => Repository -> Retrofit
     * 2. Local DB 로 부터 데이터를 가져올 때 => Room, SQLite
     *
     * 이 때, Repository 나 Local DB 로 부터 ViewModel 로 데이터를 전달해야할 때 ViewModel Factory 를 사용한다.
     *
     * 참고 : https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ko
     */

    fun plus() {
        countValue++
    }

    fun minus() {
        countValue--
    }

    fun getCount() : Int {
        return countValue
    }

}