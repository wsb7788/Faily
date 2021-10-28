package com.project.faily.ui.schedule_add


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.project.faily.ApplicationClass
import com.project.faily.R
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.databinding.FragmentDateBinding
import com.project.faily.databinding.FragmentHomeBinding
import com.project.faily.util.SharedPreferencesManager
import com.project.faily.util.getWeekDay
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs


class DateFragment : Fragment() {

    private var _binding: FragmentDateBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentDateBinding.inflate(inflater, container, false)

        val manager = SharedPreferencesManager(requireContext())
        val dayOfWeek = getDayOfWeek(binding.date.year,binding.date.month-1,binding.date.dayOfMonth)
        manager.saveDate("${binding.date.year}.${binding.date.month + 1}.${binding.date.dayOfMonth}(${dayOfWeek})")

        binding.date.setOnDateChangedListener { view, year, monthOfYear, dayOfMonth ->
            val dayOfWeek = getDayOfWeek(year,monthOfYear+1,dayOfMonth)
            manager.saveDate("$year.${monthOfYear + 1}.$dayOfMonth(${dayOfWeek})")
        }

        return binding.root
    }

    private fun getDayOfWeek(year: Int, month: Int, dayOfMonth: Int):String {
        val date = "${binding.date.year}-${binding.date.month + 1}-${binding.date.dayOfMonth}"
        return  requireContext().getWeekDay(date)

    }


}