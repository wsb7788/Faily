package com.project.faily.ui.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.project.faily.data.entities.Answer
import com.project.faily.data.remote.question.QuestionListener
import com.project.faily.databinding.FragmentQuestionBinding
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs


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
        viewModel.recentQuestionLoad()


        binding.vpQuestion.adapter = questionAdapter

        binding.vpQuestion.clipToPadding = false
        binding.vpQuestion.clipChildren = false
        binding.vpQuestion.offscreenPageLimit = 3
        binding.vpQuestion.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        //compositePageTransformer.addTransformer(MarginPageTransformer(10))
        compositePageTransformer.addTransformer { page, position ->
            val r: Float = 1 - abs(position)
            page.scaleY = (0.8f + r * 0.2f)
            //page.scaleX = (0.6f + r * 0.4f)

            val viewPager = page.parent.parent as ViewPager2            //아래 설정들은 페이지간 간격(옆 페이지가 현재 페이지에 얼마나 침범하는지
            val offset = position * -(2 * 70)
                if (ViewCompat.getLayoutDirection(viewPager) == ViewCompat.LAYOUT_DIRECTION_RTL) {
                    page.translationX = -offset
                } else {
                    page.translationX = offset
                }
        }

        binding.vpQuestion.setPageTransformer(compositePageTransformer)

    }

    override fun onLoadFailure(message: String) {
        requireContext().toast(message)
    }

    override fun onLoadSuccess(result: ArrayList<Answer>) {
        val questionList= ArrayList<QuestionModel>()
        for(i in 0 until result.size-1) {
            questionList.add(QuestionModel(result[i].question,result[i].date, isAnswered = result[i].isAnswered))
        }
        questionList.add(QuestionModel(result[result.size-1].question,result[result.size-1].date,result[result.size-1].isAnswered,true))




        questionAdapter.submitList(questionList)
        questionAdapter.notifyDataSetChanged()
    }


}