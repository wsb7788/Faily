package com.project.faily.ui.setting_emoji_add

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.project.faily.R
import com.project.faily.data.remote.setting_emoji.Emoji
import com.project.faily.data.remote.setting_emoji_add.SettingEmojiAddListener
import com.project.faily.databinding.*
import com.project.faily.ui.BaseActivity
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingEmojiAddActivity : BaseActivity(), SettingEmojiAddListener {
    private lateinit var binding: ActivitySettingEmojiAddBinding
    private val viewModel: SettingEmojiAddViewModel by viewModel()

    private lateinit var designAdapter: DesignRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_emoji_add)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.settingEmojiAddListener = this

        recyclerInit()
        viewModel.loadEmoji()


        binding.btnBack.setOnClickListener(this)
    }

    private fun recyclerInit() {
        designAdapter = DesignRecyclerAdapter()

        binding.rcvEmojiDesign.apply {
            layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)
            adapter = designAdapter
        }


        val myModel = ArrayList<DesignModel>()

        myModel.add(DesignModel(R.drawable.design1))
        myModel.add(DesignModel(R.drawable.design2))
        myModel.add(DesignModel(R.drawable.design3))
        myModel.add(DesignModel(R.drawable.design4))
        myModel.add(DesignModel(R.drawable.design5))
        myModel.add(DesignModel(R.drawable.design6))
        designAdapter.submitList(myModel)
        designAdapter.notifyDataSetChanged()

    }

    override fun onClick(v: View?) {
        when(v){
            binding.btnBack -> onBackPressed()
        }
    }

    override fun onFailure(message: String) {
        applicationContext.toast(message)
    }

    override fun onSuccess(result: ArrayList<Emoji>) {

    }
}

