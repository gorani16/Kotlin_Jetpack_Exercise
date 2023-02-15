package com.gorani.jetpack_exercise.ex_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gorani.jetpack_exercise.R
import com.gorani.jetpack_exercise.databinding.ActivityViewModelBinding

/**
 * ViewModel
 * - 안드로이드의 생명주기를 관리하기 쉽다.
 * - onSaveInstanceState() 를 사용하여 데이터를 관리할 수 있지만 적절하지 않다.
 * - 상태(LifeCycle) 가 변경될 때 마다 데이터를 관리해줘야 하는데 이 관리가 편하다.
 * - UI 컨트롤러(Activity, Fragment) 에서 모든 로직을 관리하려고 하면 복잡해진다.
 *  그래서 ViewModel 을 사용하는 것이고 이것을 사용함으로써 테스트나 관리를 할 때 요긴하게 사용된다.
 *
 *  앱 실행 후 화면전환(Rotate)시 기존의 Activity 의 생명주기가 Destroy 까지 진행된 후 다시 Create 부터 실행됨. (View 가 새롭게 생성된 것임.)
 *  더하기 / 빼기 예제 : 화면을 돌리기 전 세팅했던 값들이 화면회전 이후에 사라지는 걸 확인할 수 있다.
 *  => 안드로이드 라이프사이클이 변함에 따라 따라서 데이터들이 변화되는 문제!
 *  이런 문제들을 대응하기 위해서 예외가 발생하는 케이스마다 예외처리를 해줘야하는데 아주 귀찮은 작업이다.
 *  이런 귀찮은 작업들을 알아서 처리해주는 것이 ViewModel 이다.
 */

class ViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelBinding

    private val viewModel: ActivityViewModel by lazy {
        ViewModelProvider(this)[ActivityViewModel::class.java]
    }

    private lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)

        viewModelFactory = ViewModelFactory(5000)
        binding.tvResult.text = viewModel.getCount().toString()

        clickPlus()
        clickMinus()

        initTransaction()


    }

    private fun initTransaction() {
        binding.btnShowFragment.setOnClickListener {
            val manager = supportFragmentManager
            val transaction = manager.beginTransaction()
            val fragment = ViewModelFragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    private fun clickMinus() {
        binding.btnMinus.setOnClickListener {
            viewModel.minus()
            binding.tvResult.text = viewModel.getCount().toString()
        }
    }

    private fun clickPlus() {
        binding.btnPlus.setOnClickListener {
            viewModel.plus()
            binding.tvResult.text = viewModel.getCount().toString()
        }
    }
}