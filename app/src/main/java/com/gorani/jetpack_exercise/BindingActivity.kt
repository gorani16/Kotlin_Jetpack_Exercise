package com.gorani.jetpack_exercise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.gorani.jetpack_exercise.databinding.ActivityBindingBinding

class BindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_binding)

        val array = ArrayList<String>()
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("d")
        array.add("e")
        array.add("f")
        array.add("g")

        val bindingAdapter = BindingAdapter(array)
        val rv = binding.rv
        rv.adapter = bindingAdapter
        rv.layoutManager = LinearLayoutManager(this)




    }
}