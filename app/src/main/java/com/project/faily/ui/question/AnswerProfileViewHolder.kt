package com.project.faily.ui.question

import android.graphics.BitmapFactory
import android.util.Base64
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerProfileImageBinding
import com.project.faily.databinding.SlideItemQuestionBinding
import java.io.ByteArrayInputStream

class AnswerProfileViewHolder(val binding: LayoutRecyclerProfileImageBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(answerProfileModel: AnswerProfileModel){


        val stringProfileImage = answerProfileModel.user_image       //image는 서버로부터 받은 string형태의 byte code
        val byteProfileImage = Base64.decode(stringProfileImage,0)
        val inputStream = ByteArrayInputStream(byteProfileImage)
        val image = BitmapFactory.decodeStream(inputStream)

        Glide
            .with(ApplicationClass.instance)
            .load(when(answerProfileModel.user_image){
                "원승빈" -> R.drawable.profile_sb
                "장나연" -> R.drawable.profile_ny
                "정수빈" -> R.drawable.profile_soobin
                "구본의" -> R.drawable.profile_be
                else -> ""
            })
            .circleCrop()
            .placeholder(R.drawable.ic_profile_basic)
            .into(binding.ivImage)
    }
}