package com.gorani.jetpack_exercise.ex_map_switchmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gorani.jetpack_exercise.R
import com.gorani.jetpack_exercise.databinding.ActivityMapBinding

/**
 * LiveData Transformations
 * - Transformations.map()
 * - Transformations.switchmap()
 *
 * 예제) 10 을 입력 시 결과값이 다음 처럼 나오도록함.
 * 1. tv_result_1 : 입력 값을 두 번 더한 값을 출력 -> 10 + 10 = 20
 * 2. tv_result_2 : 입력 값에 입력 값을 곱한 값을 출력 -> 10 * 10 = 100
 */

class MapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapBinding

    private val viewModel: MapViewModel by lazy {
        ViewModelProvider(this)[MapViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_map)

        binding.btnFunc.setOnClickListener {
            val count = binding.etInputArea.text.toString().toInt()
            viewModel.setNumber(count)
        }

        viewModel.number.observe(this) {
            binding.tvResult1.text = it.toString()
        }

        viewModel.mapNum.observe(this) {
            binding.tvResult2.text = it.toString()
        }

        viewModel.switchMapNum.observe(this) {
            binding.tvResult3.text = it.toString()
        }

    }
}