package com.gorani.jetpack_exercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.gorani.jetpack_exercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnNextActivity.setOnClickListener {
            val intent = Intent(this, NextActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "다음 액티비티로 이동합니다.", Toast.LENGTH_SHORT).show()
        }

    }
}