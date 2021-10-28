package com.project.faily.ui.question

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.project.faily.R
import com.project.faily.data.entities.Answer
import com.project.faily.data.remote.question.QuestionListener
import com.project.faily.databinding.FragmentQuestionBinding
import com.project.faily.ui.answer.AnswerActivity
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs


class QuestionFragment : Fragment(), QuestionListener ,QuestionAdapter.OnItemClickListener{

    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private val viewModel: QuestionViewModel by viewModel()


    private lateinit var questionAdapter:QuestionAdapter
    private lateinit var answerProfileAdapter:AnswerProfileAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.questionListener = this


        answerProfileAdapter = AnswerProfileAdapter()
        binding.rcvProfile.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = answerProfileAdapter
        }


        viewPagerInit()

        questionAdapter.setItemClickListener(this)

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
            questionList.add(QuestionModel(result[i].question,result[i].date, isAnswered = result[i].isAnswered,questionIndex = result[i].question_index))
        }
        questionList.add(QuestionModel(result[result.size-1].question,result[result.size-1].date,result[result.size-1].isAnswered,true,questionIndex = result[result.size-1].question_index))

        binding.vpQuestion.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                showAnswer(result[position])
                super.onPageSelected(position)
            }
        })


        questionAdapter.submitList(questionList)
        questionAdapter.notifyDataSetChanged()
        binding.vpQuestion.setCurrentItem(questionAdapter.itemCount,false)
    }

    private fun showAnswer(answer: Answer) {

        when(answer.answerInfo.size){
            0 -> binding.ivAnswerPerson.setImageResource(R.drawable.ic_answer_person_0)
            1 -> binding.ivAnswerPerson.setImageResource(R.drawable.ic_answer_person_1)
            2 -> binding.ivAnswerPerson.setImageResource(R.drawable.ic_answer_person_2)
            3 -> binding.ivAnswerPerson.setImageResource(R.drawable.ic_answer_person_3)
            4 -> binding.ivAnswerPerson.setImageResource(R.drawable.ic_answer_person_4)
        }


        val answerProfileList = ArrayList<AnswerProfileModel>()
        for(i in 0 until answer.answerInfo.size){
            answerProfileList.add(AnswerProfileModel(answer.answerInfo[i].user_image))
        }

        if(answer.isAnswered){
            binding.clMy.visibility = VISIBLE
            for(i in 0 until answer.answerInfo.size){
                if(answer.answerInfo[i].user_name == "원승빈") {
                    binding.tvMyAnswer.text = answer.answerInfo[i].answer
                }
            }
        }else
            binding.clMy.visibility = GONE
        if(answer.allAnswered){
            binding.clFamily.visibility = VISIBLE
            binding.clNo.visibility = GONE
            for(i in 0 until answer.answerInfo.size){

                if(answer.answerInfo[i].user_name == "정수빈"){
                    binding.tvPerson1.text = "정수빈의 답변"
                    binding.tvPerson1Answer.text = answer.answerInfo[i].answer
                }
                if(answer.answerInfo[i].user_name == "장나연") {
                    binding.tvPerson2.text = "장나연의 답변"
                    binding.tvPerson2Answer.text = answer.answerInfo[i].answer
                }
                if(answer.answerInfo[i].user_name == "구본의") {
                    binding.tvPerson3.text = "구본의의 답변"
                    binding.tvPerson3Answer.text = answer.answerInfo[i].answer
                }
            }
        }else{
            binding.clFamily.visibility = GONE
            binding.clNo.visibility = VISIBLE
        }

        answerProfileAdapter.clearList()
        answerProfileAdapter.submitList(answerProfileList)
        answerProfileAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View, position: Int) {
        val index = questionAdapter.getQuestionIndex(position)
        viewModel.saveQuestionInfo(index)
        val intent = Intent(context,AnswerActivity::class.java)
        intent.putExtra("title",questionAdapter.getQuestionTitle(position))
        startActivity(intent)
    }


}