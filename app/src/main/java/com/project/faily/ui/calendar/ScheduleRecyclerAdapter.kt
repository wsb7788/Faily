package com.project.faily.ui.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.faily.databinding.LayoutRecyclerHomeFamilyBinding
import com.project.faily.databinding.LayoutRecyclerHomePresentBinding
import com.project.faily.databinding.LayoutRecyclerScheduleBinding

class ScheduleRecyclerAdapter:RecyclerView.Adapter<ScheduleViewHolder>() {
    private var modelList=ArrayList<ScheduleModel>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = LayoutRecyclerScheduleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submitList(modelList:ArrayList<ScheduleModel>){
        this.modelList.addAll(modelList)
    }
    fun clearList(){
        this.modelList.clear()
    }

    override fun getItemCount(): Int = modelList.size
}