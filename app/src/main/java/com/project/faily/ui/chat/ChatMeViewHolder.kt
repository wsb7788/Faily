package com.project.faily.ui.chat

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerChatMeBinding
import com.project.faily.databinding.LayoutRecyclerChatYouBinding
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import java.util.*

class ChatMeViewHolder(val binding: LayoutRecyclerChatMeBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(chatModel: ChatModel){



        if(chatModel.content.isNullOrEmpty()){
            binding.clText.visibility = GONE
            binding.ivImage.visibility = VISIBLE
            Glide
                .with(ApplicationClass.instance)
                .load(chatModel.image)

                .placeholder(R.drawable.image_asdfasdf)
                .into(binding.ivImage)
            binding.tvImageTime.text = Date().toString().substring(11,16)
        }else{
            binding.clText.visibility = VISIBLE
            binding.ivImage.visibility = GONE
            binding.text.text = chatModel.content
            binding.tvTextTime.text = Date().toString().substring(11,16)
        }
    }
}