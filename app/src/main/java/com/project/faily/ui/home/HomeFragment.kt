package com.project.faily.ui.home


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
import com.project.faily.R
import com.project.faily.data.remote.home.HomeInfo
import com.project.faily.data.remote.home.HomeListener
import com.project.faily.data.remote.home.HomeResponse
import com.project.faily.databinding.FragmentHomeBinding
import com.project.faily.util.getWeekDay
import com.project.faily.util.toast
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.abs


class HomeFragment : Fragment(), HomeListener {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()

    private lateinit var profileRecyclerAdapter: ProfileRecyclerAdapter
    private lateinit var presentRecyclerAdapter: PresentRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.homeListener = this
        binding.familyGraph.setProgressColor(0xffFF9CA4.toInt(), 0xffFF9CA4.toInt(), 0xffFFD7D4.toInt(),
            0xffFF9CA4.toInt(), 0xffFFD7D4.toInt(), 0xffFFBCBE.toInt(), 0xffFFB2B6.toInt(),
            0xffFFAAB0.toInt(), 0xffFFA4AB.toInt(), 0xffFFA1A7.toInt(), 0xffFF9CA4.toInt()
        )






        viewModel.startLogin()
        recyclerInit()
        viewPagerInit()
        viewModel.callQuestion()
        viewModel.homeCall()



        val list2 = ArrayList<PresentModel>()
        list2.add(PresentModel(R.drawable.present1))
        list2.add(PresentModel(R.drawable.present2))
        list2.add(PresentModel(R.drawable.present3))
        list2.add(PresentModel(R.drawable.present4))
        list2.add(PresentModel(R.drawable.present5))
        presentRecyclerAdapter.submitList(list2)
        presentRecyclerAdapter.notifyDataSetChanged()

        return binding.root
    }

    private fun recyclerInit() {
        profileRecyclerAdapter = ProfileRecyclerAdapter()
        presentRecyclerAdapter = PresentRecyclerAdapter()
        binding.rcvFamily.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = profileRecyclerAdapter
        }
        binding.rcvPresent.apply{
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = presentRecyclerAdapter
        }

    }

    private fun viewPagerInit() {
        val images=ArrayList<Int>()
        for( i in 1..10){
            images.add(R.drawable.ic_emoji_nothing)
            images.add(R.drawable.ic_emoji_exciting)
            images.add(R.drawable.ic_emoji_sad)
            images.add(R.drawable.ic_emoji_sick)
            images.add(R.drawable.ic_emoji_upset)
        }

        binding.viewpager2.adapter = EmojiAdapter(images, binding.viewpager2)

        binding.viewpager2.clipToPadding = false
        binding.viewpager2.clipChildren = false
        binding.viewpager2.offscreenPageLimit = 5
        binding.viewpager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(10))
        compositePageTransformer.addTransformer(ViewPager2.PageTransformer { page, position ->
            val r:Float = 1 - abs(position)
            page.scaleY = (0.7f+r*0.3f)
            page.scaleX = (0.7f+r*0.3f)
        })
        binding.viewpager2.setPageTransformer(compositePageTransformer)
        binding.viewpager2.currentItem = 100
    }

    override fun onFailure(message: String) {
        requireContext().toast(message)
    }

    override fun onHomeCallSuccess(result: HomeInfo) {
        binding.tvToolbar.text = result.user_name

        val list = ArrayList<ProfileModel>()
        for(i in 0 until result.familyList.size){
            val model = ProfileModel(result.familyList[i].user_name,result.familyList[i].user_bonding.toInt(),result.familyList[i].user_mood,result.familyList[i].user_image)
            list.add(model)
        }
        profileRecyclerAdapter.submitList(list)
        profileRecyclerAdapter.notifyDataSetChanged()

        binding.tvCalendarDay.text = result.today.substring(7)
      //  binding.tvCalendarWeekday.text = requireContext().getWeekDay(result.today)


    }


}