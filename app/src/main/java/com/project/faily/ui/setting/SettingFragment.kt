package com.project.faily.ui.setting

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.faily.R
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.setting.SettingListener
import com.project.faily.databinding.FragmentHomeBinding
import com.project.faily.databinding.FragmentSettingBinding
import com.project.faily.ui.BaseFragment
import com.project.faily.ui.setting_emoji.SettingEmojiActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class SettingFragment : BaseFragment(), SettingListener {

    private var _binding: FragmentSettingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SettingViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentSettingBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.settingListener = this


        binding.btnEmoji.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnEmoji -> startSettingEmoji()
        }
    }

    private fun startSettingEmoji() {
        val intent = Intent(requireContext(),SettingEmojiActivity::class.java)
        startActivity(intent)
    }
}