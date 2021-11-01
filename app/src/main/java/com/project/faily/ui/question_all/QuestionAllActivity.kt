package com.project.faily.ui.question_all

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.permission.PermissionListener
import com.project.faily.data.remote.qustion_all.QuestionAllListener
import com.project.faily.databinding.ActivityPermissionBinding
import com.project.faily.databinding.ActivityQuestionAllBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuestionAllActivity : BaseActivity(), QuestionAllListener {
    private lateinit var binding: ActivityQuestionAllBinding
    private val viewModel: QuestionAllViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question_all)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.questionAllListener = this





    }

    override fun onClick(v: View?) {
        when(v){

            //수정필요
        }
    }

    private fun onPermissionCheck() {

    }
}