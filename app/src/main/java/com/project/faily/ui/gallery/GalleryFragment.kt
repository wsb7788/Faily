package com.project.faily.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.faily.R
import com.project.faily.data.remote.gallery.GalleryListener
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.databinding.FragmentGalleryBinding
import com.project.faily.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class GalleryFragment : Fragment(), GalleryListener {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GalleryViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentGalleryBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.galleryListener = this

        return binding.root
    }


}