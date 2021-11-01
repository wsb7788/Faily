package com.project.faily.ui.home

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import java.io.ByteArrayInputStream

class ProfileViewHolder(val binding: LayoutRecyclerHomeFamilyBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(profileModel:ProfileModel){
        val stringProfileImage = profileModel.image       //image는 서버로부터 받은 string형태의 byte code
        val byteProfileImage = Base64.decode(stringProfileImage,0)
        val inputStream = ByteArrayInputStream(byteProfileImage)
        val image = BitmapFactory.decodeStream(inputStream)
        Glide
            .with(ApplicationClass.instance)
            .load(image)
            .circleCrop()
            .placeholder(R.drawable.ic_profile_basic)
            .into(binding.ivProfile)

        binding.progress.progress = profileModel.percent
        binding.tvName.text = profileModel.name
        binding.progress.setProgressColor(0xffFF9EA6.toInt(),0xffFFC6CA.toInt(),0xffFFE2E4.toInt(),0xffFFFFFF.toInt(),0xffFFF2F3.toInt(),0xffFFA4AB.toInt(),
            0xffFF9FA7.toInt())

    }
}