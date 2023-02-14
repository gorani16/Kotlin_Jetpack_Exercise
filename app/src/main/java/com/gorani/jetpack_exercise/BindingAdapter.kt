package com.gorani.jetpack_exercise

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gorani.jetpack_exercise.databinding.ItemTextBinding

class BindingAdapter(private val dataSet : ArrayList<String>) : RecyclerView.Adapter<BindingAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemTextBinding ) : RecyclerView.ViewHolder(binding.root) {
        val myText: TextView = binding.tvText
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemTextBinding>(LayoutInflater.from(parent.context), R.layout.item_text, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.myText.text = dataSet[position]
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}