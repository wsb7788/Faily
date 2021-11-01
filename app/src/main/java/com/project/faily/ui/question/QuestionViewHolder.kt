package com.project.faily.ui.question

import android.content.Intent
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.ApplicationClass
import com.project.faily.databinding.SlideItemQuestionBinding
import com.project.faily.ui.answer.AnswerActivity

class QuestionViewHolder(val binding: SlideItemQuestionBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(questionModel: QuestionModel){

        binding.tvTitle.text = questionModel.title
        binding.tvDate.text = questionModel.date
        if(questionModel.isAnswered){
            binding.clAnswer.visibility = INVISIBLE
        }else
            binding.clAnswer.visibility = VISIBLE
        if(questionModel.isToday!!){
            binding.ivBookmark.visibility = VISIBLE
        }else
            binding.ivBookmark.visibility = INVISIBLE


    }
}