package com.project.faily.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding

class PresentRecyclerAdapter:RecyclerView.Adapter<PresentViewHolder>() {
    private var modelList=ArrayList<PresentModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentViewHolder {
        val binding = LayoutRecyclerHomePresentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PresentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PresentViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<PresentModel>){
        this.modelList.addAll(modelList)
    }

    override fun getItemCount(): Int = modelList.size
}