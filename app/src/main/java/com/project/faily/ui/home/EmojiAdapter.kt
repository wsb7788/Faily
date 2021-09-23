package com.project.faily.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.project.faily.databinding.SlideItemContainerBinding

class EmojiAdapter(emojis: ArrayList<Int>, viewPager2:ViewPager2): RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder>() {
    var emojis = emojis
    var viewPager2=viewPager2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiViewHolder {
        val binding = SlideItemContainerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EmojiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmojiViewHolder, position: Int) {
        holder.img.setImageResource(emojis[position])
        if(position == emojis.size -2)
            viewPager2.post(runnable)
    }

    override fun getItemCount(): Int = emojis.size

    class EmojiViewHolder(val binding: SlideItemContainerBinding):RecyclerView.ViewHolder(binding.root) {
            val img = binding.imageSlide
    }

    val runnable = Runnable {

        emojis.addAll(emojis)
        notifyDataSetChanged()
    }

}