package com.project.faily.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.faily.R
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(), HomeListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.homeListener = this
        binding.homeasd.setProgressColor(0xffFF9CA4.toInt(), 0xffFF9CA4.toInt(), 0xffFFD7D4.toInt(),
            0xffFF9CA4.toInt(), 0xffFFD7D4.toInt(), 0xffFFBCBE.toInt(), 0xffFFB2B6.toInt(),
            0xffFFAAB0.toInt(), 0xffFFA4AB.toInt(), 0xffFFA1A7.toInt(), 0xffFF9CA4.toInt()
        )
        return binding.root
    }


}