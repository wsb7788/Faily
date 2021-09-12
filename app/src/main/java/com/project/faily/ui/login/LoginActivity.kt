package com.project.faily.ui.login

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.project.faily.R
import com.project.faily.data.remote.login.LoginListener
import com.project.faily.databinding.ActivityLoginBinding
import com.project.teamsb.ui.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity:BaseActivity(),LoginListener, View.OnLongClickListener, View.OnDragListener{
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModel()


     var x:Float=0f
    var y:Float=0f
    var dx:Float=0f
    var dy:Float=0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.loginListener = this


        //binding.box.setOnTouchListener(this)
        binding.box.setOnLongClickListener(this)
        binding.box.setOnDragListener(this)
    }

/*    override fun onTouch(v: View?, event: MotionEvent?): Boolean {


        when(event!!.actionMasked){
            MotionEvent.ACTION_DOWN ->{
                y = v!!.y - event.y
            }
            MotionEvent.ACTION_MOVE ->{
                binding.box.animate()
                    .y(event.y + y)
                    .setDuration(0)
                    .start()
               *//*dy = event.y - y
                v!!.y = v.y + dy
                y=event.y*//*

            }
            MotionEvent.ACTION_UP ->{

            }
        }
        return super.onTouchEvent(event)
    }*/

    override fun onLongClick(v: View?): Boolean {
        val clipText = "This it our ClipData text"
        val item = ClipData.Item(clipText)
        val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
        val data = ClipData(clipText,mimeTypes,item)

        val dragShadowBuilder = View.DragShadowBuilder(binding.box)
        binding.box.startDragAndDrop(data,dragShadowBuilder,binding.box,0)

        //binding.box.visibility = View.INVISIBLE
        return true
    }

    override fun onDrag(v: View?, event: DragEvent?): Boolean {
        when(event!!.action){
            DragEvent.ACTION_DRAG_STARTED ->{
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED->{
                v!!.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED ->{
                v!!.invalidate()
                true
            }
            DragEvent.ACTION_DROP ->{
                Toast.makeText(this,"dragData",Toast.LENGTH_SHORT).show()
                /*val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(this,dragData,Toast.LENGTH_SHORT).show()
                v!!.invalidate()
                val vv = event.localState as View
                val owner = vv.parent as ViewGroup
                //owner.removeView(vv)
                val destination = v as LinearLayout
                //destination.addView(vv)
                //vv.visibility = View.VISIBLE*/
                true
            }
            DragEvent.ACTION_DRAG_ENDED ->{
                v!!.invalidate()
                true
            }
            else -> false
        }
        return true
    }


}