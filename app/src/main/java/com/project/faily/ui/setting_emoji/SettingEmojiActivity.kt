package com.project.faily.ui.setting_emoji

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.data.remote.setting_app.SettingAppListener
import com.project.faily.data.remote.setting_emoji.Emoji
import com.project.faily.data.remote.setting_emoji.SettingEmojiListener
import com.project.faily.data.remote.setting_profile.SettingProfileListener
import com.project.faily.data.remote.sign_up.SignUpListener
import com.project.faily.databinding.*
import com.project.faily.ui.BaseActivity
import com.project.faily.ui.home.EmojiAdapter
import com.project.faily.ui.sign_up2.SignUp2Activity
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class SettingEmojiActivity : BaseActivity(), SettingEmojiListener {
    private lateinit var binding: ActivitySettingEmojiBinding
    private val viewModel: SettingEmojiViewModel by viewModel()

    private lateinit var emojiAdapter: EmojiRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_emoji)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.settingEmojiListener = this

        recyclerInit()
        viewModel.loadEmoji()


        binding.btnBack.setOnClickListener(this)
    }

    private fun recyclerInit() {
        emojiAdapter = EmojiRecyclerAdapter()

        binding.rcvEmoji.apply {
            layoutManager = GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false)
            adapter = emojiAdapter
        }



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
        val myModel = ArrayList<EmojiModel>()



        for(i in 0 until result.size){
            myModel.add(EmojiModel(result[i].emoji))
        }
        emojiAdapter.submitList(myModel)
        emojiAdapter.notifyDataSetChanged()
    }
}

