package com.project.faily.ui.schedule_add


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.project.faily.databinding.FragmentTimeBinding
import com.project.faily.util.SharedPreferencesManager


class TimeFragment: Fragment() {

    private var _binding: FragmentTimeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentTimeBinding.inflate(inflater, container, false)
        val manager = SharedPreferencesManager(requireContext())
        manager.saveTime(binding.time.hour,binding.time.minute)
        binding.time.setOnTimeChangedListener { view, hourOfDay, minute ->
            manager.saveTime(hourOfDay,minute)
        }

        return binding.root
    }

}