package com.gorani.jetpack_exercise.ex_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gorani.jetpack_exercise.R
import com.gorani.jetpack_exercise.databinding.ActivityLiveDataBinding

/**
 * LiveData
 * 이점)
 * - UI 와 데이터 상태의 일치 보장
 * - 메모리 누수 없음
 * - 중지된 액티비티로 인한 비정상 종료 없음
 * - 수명 주기를 더 이상 수동으로 처리하지 않음
 * - 최신 데이터 유지
 * - 적절한 구성 변경 : 기기 회전(rotate) 과 같은 구성 변경으로 인해 액티비티 또는 프래그먼트가 다시 생성되면 사용 가능한 최신 데이터를 즉시 받게 된다.
 * - 리소스 공유
 *
 * 역할)
 * LifeCycle 과 결합해서 데이터를 관찰해주는 역할을 한다. : 데이터가 변하는걸 감지 + 관찰
 */

class LiveDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveDataBinding

    private val viewModel: LiveDataViewModel by lazy {
        ViewModelProvider(this)[LiveDataViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_live_data)

        binding.btnPlus.setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        binding.btnMinus.setOnClickListener {
            viewModel.minusLiveDataValue()
        }

        viewModel.liveDataValue.observe(this) {
            binding.tvResult.text = it.toString()
        }

    }
}