package com.gorani.jetpack_exercise.ex_lifecycleowner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.gorani.jetpack_exercise.R
import com.gorani.jetpack_exercise.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {

    private lateinit var binding: FragmentBlank1Binding

    private lateinit var viewModel: LifeCycleOwnerViewModel
//  or
//    private val viewModel: LifeCycleOwnerViewModel by lazy {
//        ViewModelProvider(this)[LifeCycleOwnerViewModel::class.java]
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_blank1, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[LifeCycleOwnerViewModel::class.java]

        plusValue()
        minusValue()

        viewModel.countValue.observe(viewLifecycleOwner) {
            binding.tvResult.text = it.toString()
//            binding.tvResult.text = viewModel.countValue.toString()
        }

    }

    private fun plusValue() {
        binding.btnPlus.setOnClickListener {
            viewModel.plusCountValue()
        }
    }

    private fun minusValue() {
        binding.btnMinus.setOnClickListener {
            viewModel.minusCountValue()
        }
    }

}