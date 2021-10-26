package com.project.faily.ui.question

import androidx.recyclerview.widget.RecyclerView
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.SlideItemQuestionBinding

class QuestionViewHolder(val binding: SlideItemQuestionBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(questionModel: QuestionModel){
        binding.tvTitle.text = questionModel.title
        binding.tvDate.text = questionModel.date

    }
}