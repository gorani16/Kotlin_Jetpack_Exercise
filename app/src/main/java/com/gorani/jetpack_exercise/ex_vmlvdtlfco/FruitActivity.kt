package com.gorani.jetpack_exercise.ex_vmlvdtlfco

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gorani.jetpack_exercise.R
import com.gorani.jetpack_exercise.databinding.ActivityFruitBinding

class FruitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFruitBinding

    private lateinit var viewModel: FruitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fruit)

        viewModel = ViewModelProvider(this)[FruitViewModel::class.java]
        binding.activity = this@FruitActivity
        binding.vm = viewModel
        binding.lifecycleOwner = this
        /** ㄴ> view 에서 LiveData 를 사용할 때 반드시 따라오는 코드. LifeCycle 을 관리해줌.
         * - LiveData 를 DataBinding 에서 사용할 때 LiveData 의 LifeCycleOwner 가 현재 Activity 라는 것을 명시해줘야한다.
         *  그 이유는 LiveData 는 앱 구성요소의 생명주기를 인지하는 특성 때문임.
         *  참고 : https://develop-writing.tistory.com/45
         */

    }

    fun clickNextBtn() {
        viewModel.getNextData()
    }
}