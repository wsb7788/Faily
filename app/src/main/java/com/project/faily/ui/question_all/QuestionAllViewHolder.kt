package com.project.faily.ui.question_all

import android.content.Intent
import android.view.View
import android.view.View.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.ApplicationClass
import com.project.faily.databinding.LayoutRecyclerQuestionAllBinding
import com.project.faily.databinding.SlideItemQuestionBinding
import com.project.faily.ui.answer.AnswerActivity
import com.project.faily.ui.question.AnswerProfileAdapter
import com.project.faily.ui.question.AnswerProfileModel

class QuestionAllViewHolder(val binding: LayoutRecyclerQuestionAllBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(questionAllModel: QuestionAllModel){

        binding.clShow.visibility = GONE
       binding.tvNumber.text = questionAllModel.answer.question_index.toString()
        binding.tvDate.text = questionAllModel.answer.date.toString()
        binding.tvQuestion.text = questionAllModel.answer.question

        val answerProfileAdapter = AnswerProfileAdapter()
        val myModel = ArrayList<AnswerProfileModel>()

        binding.rcvProfile.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
            adapter = answerProfileAdapter
        }
        for(i in 0 until questionAllModel.answer.answerInfo.size){

            myModel.add(AnswerProfileModel(questionAllModel.answer.answerInfo[i].user_name))
        }
        answerProfileAdapter.submitList(myModel)
        answerProfileAdapter.notifyDataSetChanged()

        if(questionAllModel.answer.isAnswered){
            binding.clMy.visibility = VISIBLE
            for(i in 0 until questionAllModel.answer.answerInfo.size){
                if(questionAllModel.answer.answerInfo[i].user_name == "원승빈") {
                    binding.tvMyAnswer.text = questionAllModel.answer.answerInfo[i].answer
                }
            }
        }else
            binding.clMy.visibility = View.GONE
        if(questionAllModel.answer.allAnswered){
            binding.clFamily.visibility = VISIBLE
            binding.clNo.visibility = View.GONE
            for(i in 0 until questionAllModel.answer.answerInfo.size){

                if(questionAllModel.answer.answerInfo[i].user_name == "정수빈"){
                    binding.tvPerson1.text = "정수빈의 답변"
                    binding.tvPerson1Answer.text = questionAllModel.answer.answerInfo[i].answer
                }
                if(questionAllModel.answer.answerInfo[i].user_name == "장나연") {
                    binding.tvPerson2.text = "장나연의 답변"
                    binding.tvPerson2Answer.text = questionAllModel.answer.answerInfo[i].answer
                }
                if(questionAllModel.answer.answerInfo[i].user_name == "구본의") {
                    binding.tvPerson3.text = "구본의의 답변"
                    binding.tvPerson3Answer.text = questionAllModel.answer.answerInfo[i].answer
                }
            }
        }else{
            binding.clFamily.visibility = View.GONE
            binding.clNo.visibility = VISIBLE
        }

        binding.btnShow.setOnClickListener {
            if(binding.clShow.visibility == GONE){
                binding.clShow.visibility = VISIBLE
            }else
                binding.clShow.visibility = GONE

        }
    }
}