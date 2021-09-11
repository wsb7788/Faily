package com.project.faily.ui.login

import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.databinding.ActivityLoginBinding
import com.project.teamsb.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity:BaseActivity(),LoginListener, View.OnDragListener{
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.loginListener = this


        binding.textView.setOnDragListener(this)
    }

    /*override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        val y:Float = event!!.x
        val x:Float = event!!.y
        val padding = binding.seekBar.paddingLeft + binding.seekBar.paddingRight
        val spos = binding.seekBar.left + binding.seekBar.paddingLeft
        val drawable = binding.seekBar.thumb
        when(event.actionMasked){
            MotionEvent.ACTION_DOWN ->{
                if(x>= drawable.bounds.left && x<= drawable.bounds.right && y <= drawable.bounds.bottom && y >= drawable.bounds.top) {
                    Log.d("로그","\nx=$x drawable.bounds.left = ${drawable.bounds.left} drawable.bounds.right = ${drawable.bounds.right}\n" +
                            "y=$y drawable.bounds.top = ${drawable.bounds.top} drawable.bounds.bottom = ${drawable.bounds.bottom}")
                    super.onTouchEvent(event)
                }else false
            }
            MotionEvent.ACTION_MOVE ->{

            }
            MotionEvent.ACTION_UP ->{

            }
        }
        return true
    }*/

    override fun onDrag(v: View?, event: DragEvent?): Boolean {
        return true
    }
}