package com.project.faily.ui.setting_emoji_add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerDesignBinding
import com.project.faily.databinding.LayoutRecyclerEmojiBinding
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding

class DesignRecyclerAdapter:RecyclerView.Adapter<DesignViewHolder>() {
    private var modelList=ArrayList<DesignModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DesignViewHolder {
        val binding = LayoutRecyclerDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DesignViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DesignViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<DesignModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
}