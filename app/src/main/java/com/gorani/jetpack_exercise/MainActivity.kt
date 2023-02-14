package com.gorani.jetpack_exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.gorani.jetpack_exercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var ageCount = 16

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.activity = this@MainActivity
        binding.person = Person("고라니", 16)

        nextActivity()

    }

    private fun nextActivity() {
        binding.btnNextActivity.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "다음 액티비티로 이동합니다.", Toast.LENGTH_SHORT).show()
        }
    }

    fun plusAge() {
        Toast.makeText(this, "버튼 클릭!", Toast.LENGTH_SHORT).show()
        ageCount++
        binding.person = Person("고라니", ageCount)
    }

}