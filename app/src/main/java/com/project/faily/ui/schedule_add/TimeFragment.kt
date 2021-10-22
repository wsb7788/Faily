package com.project.faily.ui.schedule_add


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.faily.databinding.FragmentTimeBinding


class TimeFragment : Fragment() {

    private var _binding: FragmentTimeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentTimeBinding.inflate(inflater, container, false)



        return binding.root
    }



}