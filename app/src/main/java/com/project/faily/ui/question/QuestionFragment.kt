package com.project.faily.ui.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.faily.R
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.question.QuestionListener
import com.project.faily.databinding.FragmentHomeBinding
import com.project.faily.databinding.FragmentQuestionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class QuestionFragment : Fragment(), QuestionListener {

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuestionViewModel by viewModel()


    private lateinit var questionAdapter:QuestionAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.questionListener = this



        viewPagerInit()

        return binding.root
    }

    private fun viewPagerInit() {
        questionAdapter = QuestionAdapter()
        val questionList= ArrayList<QuestionModel>()


        for(i in 0..10){
            questionList.add(QuestionModel("앙기모띠","ㅁㄴㅇㄻㄴㅇㄹ", isAndswered = false, isToday = false))
        }

        binding.vpQuestion.adapter = questionAdapter
        questionAdapter.submitList(questionList)
        questionAdapter.notifyDataSetChanged()

    }


}