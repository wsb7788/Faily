package com.project.faily.ui.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import com.project.faily.databinding.SlideItemOnboardingBinding
import com.project.faily.databinding.SlideItemQuestionBinding

class OnboardingAdapter:RecyclerView.Adapter<OnBoardingViewHolder>() {


    private var modelList=ArrayList<OnBoardingModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        val binding = SlideItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return OnBoardingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<OnBoardingModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
}