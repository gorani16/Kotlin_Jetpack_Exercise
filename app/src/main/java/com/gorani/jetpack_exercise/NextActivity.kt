package com.gorani.jetpack_exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.gorani.jetpack_exercise.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_next)
        /**
         * 프래그먼트 매니저 : 액티비티와 프래그먼트의 중간에서 서로를 이어주는 역할을 한다. 프래그먼트 전환 애니메이션 설정도 가능하다.
         * 역할)
         * 1. 프래그먼트 트랜잭션 : 프래그먼트 추가, 삭제, 교체 등의 작업을 수행할 수 있게 해주며, 행해진 트랜잭션의 상태를 프래그먼트 백스택에 저장할 수 있도록 해줌다.
         * 2. 액티비티와의 통신 : 단일 프래그먼트에 대해 세부적인 작업 또한 가능하다. 프래그먼트 내의 구성요소들 하나하나에 접근할 수 있도록 해준다.
         * 액티비티에서 특정 이벤트가 발생했을 때, 프래그먼트에서 적절한 동작을 할 수 있도록 한다.
         *
         * 참고)
         * https://colinch4.github.io/2020-11-25/Fragment-manager/
         * https://juahnpop.tistory.com/224
         */

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val fragment = FrameFragment()
        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)    // 프래그먼트 백스택 : 백스택을 사용하면 프래그먼트를 back key 를 이용하여 이전 상태로 돌릴 수 있다.
        transaction.commit()

    }
}