package com.project.faily.ui.question_all

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.project.faily.R
import com.project.faily.data.entities.Answer
import com.project.faily.data.remote.permission.PermissionListener
import com.project.faily.data.remote.qustion_all.QuestionAllListener
import com.project.faily.databinding.ActivityPermissionBinding
import com.project.faily.databinding.ActivityQuestionAllBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class QuestionAllActivity : BaseActivity(), QuestionAllListener {
    private lateinit var binding: ActivityQuestionAllBinding
    private val viewModel: QuestionAllViewModel by viewModel()


    private lateinit var questionAllRecyclerAdapter: QuestionAllRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question_all)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.questionAllListener = this



        recyclerInit()
        viewModel.allQuestionLoad()
    }

    private fun recyclerInit() {
        questionAllRecyclerAdapter = QuestionAllRecyclerAdapter()
        binding.rcv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = questionAllRecyclerAdapter
        }
    }

    override fun onClick(v: View?) {
        when(v){

            //수정필요
        }
    }



    override fun onLoadSuccess(result: ArrayList<Answer>) {
        val myModel = ArrayList<QuestionAllModel>()

        for(i in 0 until result.size){
            myModel.add(QuestionAllModel(result[i]))
        }
        questionAllRecyclerAdapter.submitList(myModel)
        questionAllRecyclerAdapter.notifyDataSetChanged()
    }

    override fun onLoadFailure(message: String) {
        applicationContext.toast(message)
    }
}