package com.gorani.jetpack_exercise.ex_lifecycleowner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.gorani.jetpack_exercise.R
import com.gorani.jetpack_exercise.databinding.ActivityLifeCycleOwnerBinding


class LifeCycleOwnerActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityLifeCycleOwnerBinding

    private val manager = supportFragmentManager
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_life_cycle_owner)

        binding.btn1.setOnClickListener {
            val fragment1 = BlankFragment1()
            initTransaction(fragment1)
            Toast.makeText(this, "변경 : fragment 1", Toast.LENGTH_SHORT).show()
        }

        binding.btn2.setOnClickListener {
            val fragment2 = BlankFragment2()
            initTransaction(fragment2)
            Toast.makeText(this, "변경 : fragment 2", Toast.LENGTH_SHORT).show()
        }

        /**
         * TODO
         * 3. 프래그먼트 1 에 더하기 버튼 배치 -> LiveData 값 증가
         */

    }

    private fun initTransaction(fragment: Fragment) {
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.frameArea, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}