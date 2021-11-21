package com.bartex.classjobless4.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Constsnts
import com.bartex.classjobless4.entity.Lessons
import com.bartex.classjobless4.ui.adapters.HomeworksRVAdapter
import com.bartex.classjobless4.ui.adapters.LessonsRVAdapter
import java.util.*

class HomeFragment : Fragment(), MyTimerExam.OnTimeListener{

private lateinit var  days:TextView
private lateinit var  hours:TextView
private lateinit var  minutes:TextView
private lateinit var  rvLessons:RecyclerView
private lateinit var  rvHomeworks:RecyclerView
private lateinit var  adapterLess:LessonsRVAdapter
private lateinit var  adapterHw:HomeworksRVAdapter
private lateinit var  tvLessNumber:TextView
private lateinit var  tvLast:TextView

    private lateinit var navController: NavController
    private val homeViewModel by lazy { ViewModelProvider(requireActivity())[HomeViewModel::class.java]}

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initViews(view)
        initAdapters()

        homeViewModel.setOnTimeListener(this)

        if (!homeViewModel.getIsTime() ){
            //меняем флаг
            homeViewModel.setIsTime(true)
            homeViewModel.onStartTimer()
        }

      val listLessons =   homeViewModel.getLessons()
        adapterLess.listData = listLessons
        tvLessNumber.text = String.format(getString(R.string.lessNow2), listLessons.size)

        val listHw = homeViewModel.getHomeworks()
        adapterHw.listHw = listHw

        requireActivity().invalidateOptionsMenu()
    }

    private fun initAdapters() {
        rvLessons.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        adapterLess = LessonsRVAdapter(getOnClickListener(), getOnVideoListener())
        rvLessons.adapter = adapterLess

        rvHomeworks.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        adapterHw = HomeworksRVAdapter()
        rvHomeworks.adapter = adapterHw
    }

    private fun getOnVideoListener(): LessonsRVAdapter.OnVideoClickListener {
        return object : LessonsRVAdapter.OnVideoClickListener{
            override fun onVideoClick(lesson: Lessons) {
                val bundle = Bundle()
                    bundle. putParcelable(Constsnts.CLASSES, lesson)
                    navController.navigate(R.id.videoFragment, bundle)
            }
        }
    }

    private fun getOnClickListener(): LessonsRVAdapter.OnItemClickListener {
        return object : LessonsRVAdapter.OnItemClickListener{
            override fun onItemClick() {
                navController.navigate(R.id.navigation_lessons)
            }
        }
    }

    private fun initViews(view: View){
        days = view.findViewById(R.id.days)
        hours = view.findViewById(R.id.hours)
        minutes = view.findViewById(R.id.minutes)
        rvLessons = view.findViewById(R.id.rv_Lessons)
        rvHomeworks = view.findViewById(R.id.rv_homework)
        tvLessNumber = view.findViewById(R.id.tvLessNumber)
        tvLast = view.findViewById(R.id.tv_last)
    }

    override fun onTime(time: Long) {
        //val day = (time / 86400000 % 365).toInt()
        val hour = (time / 3600000 % 24).toInt()
        val minut = (time / 60000 % 60).toInt()
        val second = (time / 1000 % 60).toInt()
        //val decim = Math.round((time % 1000 / 100).toFloat())

        days.text =String.format(Locale.getDefault(), "%02d", hour)
        hours.text =String.format(Locale.getDefault(), "%02d", minut)
        minutes.text =String.format(Locale.getDefault(), "%02d", second)
        if (time <= 0){
            tvLast.text = getString(R.string.exam)
            tvLast.setTextColor(Color.RED)
        }
    }

}