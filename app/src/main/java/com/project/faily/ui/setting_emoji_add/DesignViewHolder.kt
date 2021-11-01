package com.project.faily.ui.setting_emoji_add

import android.graphics.BitmapFactory
import android.util.Base64
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerDesignBinding
import com.project.faily.databinding.LayoutRecyclerEmojiBinding
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import java.io.ByteArrayInputStream

class DesignViewHolder(val binding: LayoutRecyclerDesignBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(designModel: DesignModel){
        val stringProfileImage = designModel.image       //image는 서버로부터 받은 string형태의 byte code
        val byteProfileImage = Base64.decode(stringProfileImage,0)
        val inputStream = ByteArrayInputStream(byteProfileImage)
        val image = BitmapFactory.decodeStream(inputStream)
        Glide
            .with(ApplicationClass.instance)
            .load(image)
            .placeholder(R.drawable.ic_profile_basic)
            .into(binding.ivDesign)

    }
}