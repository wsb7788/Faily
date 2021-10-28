package com.project.faily.ui.question

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import com.project.faily.databinding.SlideItemQuestionBinding

class QuestionAdapter:RecyclerView.Adapter<QuestionViewHolder>() {


    private var modelList=ArrayList<QuestionModel>()

    private lateinit var itemClickListener : OnItemClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val binding = SlideItemQuestionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(modelList[position])
        holder.binding.clAnswer.setOnClickListener{
            itemClickListener.onClick(it,position)
        }
    }

    fun submitList(modelList:ArrayList<QuestionModel>){
        this.modelList.addAll(modelList)
    }
    fun getQuestionIndex(position:Int):Int = modelList[position].questionIndex
    fun getQuestionTitle(position:Int):String = modelList[position].title

    override fun getItemCount(): Int = modelList.size

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
}