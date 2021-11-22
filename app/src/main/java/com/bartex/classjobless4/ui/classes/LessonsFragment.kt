package com.bartex.classjobless4.ui.classes

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
import com.bartex.classjobless4.entity.Constants
import com.bartex.classjobless4.entity.Lessons
import com.bartex.classjobless4.ui.adapters.LessonsRVAdapter

class LessonsFragment : Fragment() {

    companion object{
        const val TAG = "33333"
    }

    private lateinit var navController: NavController
    private lateinit var lessonsViewModel: LessonsViewModel
    private lateinit var  rvLessons: RecyclerView
    private lateinit var  adapterLess:LessonsRVAdapter
    private lateinit var  tvDateType:TextView
    //private val model by lazy{ ViewModelProvider(this)[SharedViewModel::class.java] }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_classes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lessonsViewModel = ViewModelProvider(this).get(LessonsViewModel::class.java)
        navController = Navigation.findNavController(view)

        initViews(view)
        initAdapters()

        val listLessons =   lessonsViewModel.getLessons()
        adapterLess.listData = listLessons
        tvDateType.text =listLessons[0].date

        requireActivity().invalidateOptionsMenu()
    }

    private fun initViews(view: View){
        rvLessons = view.findViewById(R.id.rv_Lessons_type)
        tvDateType = view.findViewById(R.id.tvDateType)

    }

    private fun initAdapters() {
        rvLessons.layoutManager = LinearLayoutManager(requireActivity())
        adapterLess = LessonsRVAdapter(getOnClickListener(),getOnVideoListener(), false)
        rvLessons.adapter = adapterLess
    }

    private fun getOnVideoListener(): LessonsRVAdapter.OnVideoClickListener {
        return object : LessonsRVAdapter.OnVideoClickListener{
            override fun onVideoClick(lesson: Lessons) {
                val bundle = Bundle()
                bundle. putParcelable(Constants.CLASSES, lesson)
                navController.navigate(R.id.videoFragment, bundle)
            }
        }
    }

    private fun getOnClickListener(): LessonsRVAdapter.OnItemClickListener {
        return object : LessonsRVAdapter.OnItemClickListener{
            override fun onItemClick() {
               //ничего - так как в этом фрагменте не используется
            }
        }
    }
}