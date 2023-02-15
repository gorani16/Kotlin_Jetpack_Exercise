package com.gorani.jetpack_exercise.ex_viewmodel

import androidx.lifecycle.ViewModel

/**
 * ViewModel 에서 아래와 같이 변수 하나만 만들어서 사용하지는 않고
 * LiveData (etc) 와 함께 사용한다.
 */

class ActivityViewModel : ViewModel() {

    private var countValue: Int = 0

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