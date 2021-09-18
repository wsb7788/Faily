package com.project.faily.ui.permission

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.permission.PermissionListener
import com.project.faily.databinding.ActivityPermissionBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PermissionActivity : BaseActivity(), PermissionListener {
    private lateinit var binding: ActivityPermissionBinding
    private val viewModel: PermissionViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_permission)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.permissionListener = this




        binding.button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding.button -> onPermissionCheck()
            //수정필요
        }
    }

    private fun onPermissionCheck() {

    }
}