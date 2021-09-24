package com.project.faily.ui.calendar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.faily.R
import com.project.faily.data.remote.calendar.CalendarListener
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.databinding.FragmentCalendarBinding
import com.project.faily.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class CalendarFragment : Fragment(), CalendarListener {

    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: CalendarViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.calendarListener = this

        return binding.root
    }


}