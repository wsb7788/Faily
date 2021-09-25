package com.project.faily.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding

class PresentViewHolder(val binding: LayoutRecyclerHomePresentBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(presentModel: PresentModel){

        binding.ivPresent.setImageResource(R.drawable.ic_present)
    }
}