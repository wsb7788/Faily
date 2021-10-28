package com.project.faily.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding

class ProfileViewHolder(val binding: LayoutRecyclerHomeFamilyBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(profileModel:ProfileModel){

        Glide
            .with(ApplicationClass.instance)
            .load(profileModel.image)
            .circleCrop()
            .placeholder(R.drawable.ic_profile_basic)
            .into(binding.ivProfile)
        binding.progress.progress = profileModel.percent
        binding.tvName.text = profileModel.name
        binding.progress.setProgressColor(0xffFF9EA6.toInt(),0xffFFC6CA.toInt(),0xffFFE2E4.toInt(),0xffFFFFFF.toInt(),0xffFFF2F3.toInt(),0xffFFA4AB.toInt(),
            0xffFF9FA7.toInt())

    }
}