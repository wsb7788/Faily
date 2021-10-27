package com.project.faily.ui.question

import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerProfileImageBinding
import com.project.faily.databinding.SlideItemQuestionBinding

class AnswerProfileViewHolder(val binding: LayoutRecyclerProfileImageBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(answerProfileModel: AnswerProfileModel){
        Glide
            .with(ApplicationClass.instance)
            .load(answerProfileModel.user_image)
            .circleCrop()
            .placeholder(R.drawable.ic_profile_basic)
            .into(binding.ivImage)
    }
}