package com.project.faily.ui.schedule_add

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.project.faily.R
import org.koin.androidx.viewmodel.ext.android.viewModel


class ColorDialog(val itemClick: (Int) -> Unit): BottomSheetDialogFragment() {

    private val viewModel: ScheduleAddViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val anniversary: ConstraintLayout = view.findViewById(R.id.cl_anniversary)
        val family: ConstraintLayout = view.findViewById(R.id.cl_family)
        val personal: ConstraintLayout = view.findViewById(R.id.cl_personal)
        val normal: ConstraintLayout = view.findViewById(R.id.cl_normal)

        anniversary.setOnClickListener {
            itemClick(0)
            dialog?.dismiss()
        }
        family.setOnClickListener {
            itemClick(1)
            dialog?.dismiss()
        }
        personal.setOnClickListener {
            itemClick(2)
            dialog?.dismiss()
        }
        normal.setOnClickListener {
            itemClick(3)
            dialog?.dismiss()
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

        return inflater.inflate(R.layout.dialog_schedule_color, container, false)
    }


}