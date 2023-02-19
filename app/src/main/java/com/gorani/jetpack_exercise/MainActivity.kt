package com.gorani.jetpack_exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.gorani.jetpack_exercise.databinding.ActivityMainBinding
import com.gorani.jetpack_exercise.ex_lifecycleowner.LifeCycleOwnerActivity
import com.gorani.jetpack_exercise.ex_livedata.LiveDataActivity
import com.gorani.jetpack_exercise.ex_map_switchmap.MapActivity
import com.gorani.jetpack_exercise.ex_viewmodel.ViewModelActivity
import com.gorani.jetpack_exercise.ex_vmlvdtlfco.FruitActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var ageCount = 15

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.activity = this@MainActivity
        binding.person = Person("고라니", 16)

        nextActivity()
        bindingActivity()
        viewModelActivity()
        liveDataActivity()
        lifeCycleOwnerActivity()
        mapActivity()
        fruitActivity()

    }

    fun plusAge() {
        Toast.makeText(this, "버튼 클릭!", Toast.LENGTH_SHORT).show()
        ageCount++
        binding.person = Person("WaterDeer", ageCount)
    }

    private fun fruitActivity() {
        binding.btnFruitActivity.setOnClickListener {
            val intent = Intent(this, FruitActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Fruit Activity 로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }


    private fun mapActivity() {
        binding.btnMapActivity.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Map Activity 로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun lifeCycleOwnerActivity() {
        binding.btnLifeCycleOwnerActivity.setOnClickListener {
            val intent = Intent(this, LifeCycleOwnerActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "LifeCycleOwner Activity 로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun liveDataActivity() {
        binding.btnLiveDataActivity.setOnClickListener {
            val intent = Intent(this, LiveDataActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "LiveData Activity 로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun viewModelActivity() {
        binding.btnViewModelActivity.setOnClickListener {
            val intent = Intent(this, ViewModelActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "ViewModel Activity 로 이동합니다.", Toast.LENGTH_SHORT).show()
        }

    }

    private fun bindingActivity() {
        binding.btnBindingActivity.setOnClickListener {
            val intent = Intent(this, BindingActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Binding Activity 로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun nextActivity() {
        binding.btnNextActivity.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Next Activity 로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }

}