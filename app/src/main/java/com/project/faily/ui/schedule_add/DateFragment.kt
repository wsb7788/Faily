package com.project.faily.ui.schedule_add


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.project.faily.R
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.databinding.FragmentDateBinding
import com.project.faily.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs


class DateFragment : Fragment() {

    private var _binding: FragmentDateBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentDateBinding.inflate(inflater, container, false)



        return binding.root
    }



}