package com.gorani.jetpack_exercise.ex_vmlvdtlfco

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class FruitViewModel : ViewModel() {

    private val _word = MutableLiveData("")
    val word: LiveData<String> = _word

    private val _shuffledWord = MutableLiveData("")
    val shuffledWord: LiveData<String> = _shuffledWord

    val newData = Transformations.switchMap(word) {
        getRandomWordShuffled(it)
    }

    fun getNextData() {
        val currentWord = testDataList.random()
        val shuffledWord = currentWord.toCharArray()
        shuffledWord.shuffle()

        _word.value = currentWord
        _shuffledWord.value = String(shuffledWord)
//        _shuffledWord.value = shuffledWord.toString() // 메모리 주소값이 섞인 형태로 나옴

    }

    private fun getRandomWordShuffled(word: String) : MutableLiveData<String> {
        val tempLiveData = MutableLiveData("")
        val randomTextWord = word.toCharArray()
        randomTextWord.shuffle()
        tempLiveData.value = String(randomTextWord)
        return tempLiveData
    }


}