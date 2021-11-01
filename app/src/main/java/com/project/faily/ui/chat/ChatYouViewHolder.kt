package com.project.faily.ui.chat

import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.databinding.LayoutRecyclerChatYouBinding
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import java.util.*

class ChatYouViewHolder(val binding: LayoutRecyclerChatYouBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(chatModel: ChatModel){


        when(chatModel.index){
            0->{
                binding.tvName.text = "본의"
                Glide
                    .with(ApplicationClass.instance)
                    .load(R.drawable.profile_be)
                    .circleCrop()
                    .placeholder(R.drawable.profile_be)
                    .into(binding.ivProfile)
            }
            1->{
                binding.tvName.text = "수빈"
                Glide
                    .with(ApplicationClass.instance)
                    .load(R.drawable.profile_soobin)
                    .circleCrop()
                    .placeholder(R.drawable.profile_soobin)
                    .into(binding.ivProfile)
            }
            2->{
                binding.tvName.text = "나연"
                Glide
                    .with(ApplicationClass.instance)
                    .load(R.drawable.profile_ny)
                    .circleCrop()
                    .placeholder(R.drawable.profile_ny)
                    .into(binding.ivProfile)
            }

        }


        if(chatModel.content.isNullOrEmpty()){
            binding.clText.visibility = GONE
            binding.ivImage.visibility = VISIBLE
            Glide
                .with(ApplicationClass.instance)
                .load(chatModel.image)
                .circleCrop()
                .placeholder(R.drawable.ic_emoji_exciting)
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