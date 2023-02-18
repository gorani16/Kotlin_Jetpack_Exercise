package com.gorani.jetpack_exercise.ex_map_switchmap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Transformations -> map / switchMap
 * LiveData 의 값을 변환시키고 싶을 때, map / switchMap 을 사용하여 변환한다. (별도의 연산처리를 하고싶을 때)
 * Activity 에서 LiveData 의 값을 변환시키는 로직을 ViewModel 에서 구현하고
 * 그 값을 변환시키는 로직은 map / switchMap 을 사용하여 구현한다.
 * - map : 입력값을 연산처리한 값으로 변환 후 변환된 값으로 return (연산처리 : +)
 * - switchMap : 입력값을 연산처리 해주는 별도의 함수를 만들어서 : changeNum
 * 이 함수를 실행 시킬 변수를 만들고 : switchNum
 * 그 변수에 변환시키고자하는 값을 switchMap 의 파라미터에 넣고 : Transformations.switchMap(number)
 * 람다 안에 별도의 함수(changeNum) 를 실행시키도록 한다.
 */

class MapViewModel : ViewModel() {

    private val _number = MutableLiveData(0)
    val number = _number

    val mapNum = Transformations.map(number) {
        it + it
    }

    val switchMapNum = Transformations.switchMap(number) {
        changeNum(it)
    }

    fun setNumber(count: Int) {
        _number.value = count
    }

    private fun changeNum(num: Int) : MutableLiveData<Int> {
        return MutableLiveData(num * num)
    }

}