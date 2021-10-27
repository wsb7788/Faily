package com.project.faily.ui.question

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import com.project.faily.databinding.LayoutRecyclerProfileImageBinding
import com.project.faily.databinding.SlideItemQuestionBinding

class AnswerProfileAdapter:RecyclerView.Adapter<AnswerProfileViewHolder>() {


    private var modelList=ArrayList<AnswerProfileModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerProfileViewHolder {
        val binding = LayoutRecyclerProfileImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AnswerProfileViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnswerProfileViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<AnswerProfileModel>){
        this.modelList.addAll(modelList)
    }
    fun clearList(){
        this.modelList.clear()
    }

    override fun getItemCount(): Int = modelList.size
}