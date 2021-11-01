package com.project.faily.ui.setting_emoji

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerEmojiBinding
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding

class EmojiRecyclerAdapter:RecyclerView.Adapter<EmojiViewHolder>() {
    private var modelList=ArrayList<EmojiModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
        val binding = LayoutRecyclerEmojiBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EmojiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<EmojiModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
}