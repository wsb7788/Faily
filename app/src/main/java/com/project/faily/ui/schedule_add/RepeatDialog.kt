package com.project.faily.ui.schedule_add

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.project.faily.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class RepeatDialog(val value: String, val itemClick: (Int) -> Unit): BottomSheetDialogFragment() {


    private val viewModel: ScheduleAddViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val no:ConstraintLayout = view.findViewById(R.id.cl_no)
        val week:ConstraintLayout = view.findViewById(R.id.cl_week)
        val month:ConstraintLayout = view.findViewById(R.id.cl_month)
        val year:ConstraintLayout = view.findViewById(R.id.cl_year)

        when(value){
            "안함" -> view.findViewById<ImageView>(R.id.iv_no).setImageResource(R.drawable.ic_radio_checked)
            "매주" -> view.findViewById<ImageView>(R.id.iv_week).setImageResource(R.drawable.ic_radio_checked)
            "매월" -> view.findViewById<ImageView>(R.id.iv_month).setImageResource(R.drawable.ic_radio_checked)
            "매년" -> view.findViewById<ImageView>(R.id.iv_year).setImageResource(R.drawable.ic_radio_checked)
        }
        no.setOnClickListener {
            itemClick(0)
            dismiss()
        }
        week.setOnClickListener {
            itemClick(1)
            dismiss()
        }
        month.setOnClickListener {
            itemClick(2)
            dismiss()
        }
        year.setOnClickListener {
            itemClick(3)
            dismiss()
        }


    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.dialog_schedule_repeat, container, false)



        return view
    }


}