package com.project.faily.ui.home

import android.graphics.Color
import android.graphics.Shader
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.databinding.ActivityHomeBinding
import com.project.faily.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity: BaseActivity(),HomeListener{
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.homeListener = this
 /*       0xFF4FEAAC,0xFFA8DD51,0xFFE8D30F,0xFFA8DD51,0xFF4FEAAC
        val color = ArrayList<Color>(-0xb01554, -0x5722af, -0x172cf1, -0x5722af, -0xb01554)*/

       /* binding.homeasd.setProgressColor(0xffFFD7D4.toInt(),
            0xffFFD2D1.toInt(), 0xffFFC8C8.toInt(), 0xffFFBCBE.toInt(), 0xffFFB2B6.toInt(),
            0xffFFAAB0.toInt(), 0xffFFA4AB.toInt(), 0xffFFA1A7.toInt(), 0xffFF9CA4.toInt()
        )*/
        binding.homeasd.setProgressColor(0xffFF9CA4.toInt(), 0xffFF9CA4.toInt(), 0xffFFD7D4.toInt(),
            0xffFF9CA4.toInt(), 0xffFFD7D4.toInt(), 0xffFFBCBE.toInt(), 0xffFFB2B6.toInt(),
            0xffFFAAB0.toInt(), 0xffFFA4AB.toInt(), 0xffFFA1A7.toInt(), 0xffFF9CA4.toInt()
        )
    }


}