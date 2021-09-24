package com.project.faily.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding

class ProfileViewHolder(val binding: LayoutRecyclerHomeFamilyBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(profileModel:ProfileModel){

        binding.ivEmoji.setImageResource(R.drawable.ic_emoji_nothing)
        binding.progress.progress = 80
        binding.tvName.text = "앙기모띠"
        binding.progress.setProgressColor(0xffFF9EA6.toInt(),0xffFFC6CA.toInt(),0xffFFE2E4.toInt(),0xffFFFFFF.toInt(),0xffFFF2F3.toInt(),0xffFFA4AB.toInt(),
            0xffFF9FA7.toInt())

    }
}