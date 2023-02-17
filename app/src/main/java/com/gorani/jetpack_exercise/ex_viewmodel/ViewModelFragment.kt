package com.gorani.jetpack_exercise.ex_viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.gorani.jetpack_exercise.R
import com.gorani.jetpack_exercise.databinding.FragmentViewModelBinding

/**
 * Activity 의 ViewModel 의 데이터를 공유하여 Fragment 에 가져오기
 */

class ViewModelFragment : Fragment() {

    private lateinit var binding: FragmentViewModelBinding

    private val viewModel: ActivityViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_model, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvFragment.text = viewModel.getCount().toString()

    }

}