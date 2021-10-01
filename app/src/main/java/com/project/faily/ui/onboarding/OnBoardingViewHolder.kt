package com.project.faily.ui.onboarding

import androidx.recyclerview.widget.RecyclerView
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.SlideItemOnboardingBinding
import com.project.faily.databinding.SlideItemQuestionBinding

class OnBoardingViewHolder(val binding: SlideItemOnboardingBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(onBoardingModel: OnBoardingModel){

        binding.ivOnboarding.setImageResource(onBoardingModel.image)
        binding.tvTitle.text = onBoardingModel.title
        binding.tvContent.text = onBoardingModel.content

    }
}