package com.project.faily.ui.question_all

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerEmojiBinding
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerQuestionAllBinding

class QuestionAllRecyclerAdapter:RecyclerView.Adapter<QuestionAllViewHolder>() {
    private var modelList=ArrayList<QuestionAllModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAllViewHolder {
        val binding = LayoutRecyclerQuestionAllBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionAllViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionAllViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<QuestionAllModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
}