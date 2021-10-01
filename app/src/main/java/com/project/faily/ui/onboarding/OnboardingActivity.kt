package com.project.faily.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.data.remote.permission.PermissionListener
import com.project.faily.databinding.ActivityOnboardingBinding
import com.project.faily.databinding.ActivityPermissionBinding
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.login.LoginActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnboardingActivity : BaseActivity() {
    private lateinit var binding: ActivityOnboardingBinding


    private lateinit var onboardingAdapter:OnboardingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        binding.lifecycleOwner = this


        viewPagerInit()

        binding.btnStart.setOnClickListener(this)
        binding.btnSkip.setOnClickListener(this)
    }

    private fun viewPagerInit() {
        onboardingAdapter = OnboardingAdapter()
        val list = ArrayList<OnBoardingModel>()

        list.add(OnBoardingModel(
            R.drawable.ic_onboarding_chat,
        "가족 모두가 함께하는 채팅",
        "채팅을 따로 개설할 필요가 없어요. 페일리의 채팅에서 자유롭게 일상의 대화를 나눠 보세요."))
        list.add(OnBoardingModel(
            R.drawable.ic_onboarding_question,
            "매일 주어지는 질문",
            "같은 질문이 가족들에게 전달됩니다. 서로의 답변을 확인하고 이에 대해 이야기 해보세요."))
        list.add(OnBoardingModel(
            R.drawable.ic_onboarding_emoji,
            "이모티콘",
            "채팅방에서 쓰인 사진이 이모티콘으로 제작됩니다. 각자의 얼굴이 담긴 이모티콘을 사용해 보세요."))
        list.add(OnBoardingModel(
            R.drawable.ic_onboarding_graph,
            "1에서 100, 가족의 유대감",
            "매일 새로운 질문과 특별한 이모티콘으로 대화를 지속하여 유대감을 100%로 만들어 보세요."))

        binding.vpOnboarding.adapter = onboardingAdapter
        onboardingAdapter.submitList(list)
        onboardingAdapter.notifyDataSetChanged()

        binding.vpOnboarding.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                when(position){
                    0 ->{
                        binding.indicator1.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.primary_pink))
                        binding.indicator2.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator3.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator4.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.btnStart.visibility = INVISIBLE
                        binding.btnSkip.visibility = VISIBLE
                            }
                    1 ->{
                        binding.indicator1.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator2.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.primary_pink))
                        binding.indicator3.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator4.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.btnStart.visibility = INVISIBLE
                        binding.btnSkip.visibility = VISIBLE
                    }
                    2 ->{
                        binding.indicator1.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator2.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator3.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.primary_pink))
                        binding.indicator4.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.btnStart.visibility = INVISIBLE
                        binding.btnSkip.visibility = VISIBLE
                    }
                    3 ->{
                        binding.indicator1.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator2.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator3.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.gray_1))
                        binding.indicator4.setColorFilter(ContextCompat.getColor(ApplicationClass.instance, R.color.primary_pink))
                        binding.btnStart.visibility = VISIBLE
                        binding.btnSkip.visibility = INVISIBLE
                    }
                }
            }
        })
    }

    override fun onClick(v: View?) {
        onStartLogin()
    }

    private fun onStartLogin() {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}