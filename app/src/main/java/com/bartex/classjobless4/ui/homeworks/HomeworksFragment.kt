package com.bartex.classjobless4.ui.homeworks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bartex.classjobless4.R

class HomeworksFragment : Fragment() {

    private lateinit var notificationsViewModel: HomeworksViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(HomeworksViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_homeworks, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner,  {
            textView.text = it
        })
        return root
    }
}