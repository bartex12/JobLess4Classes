package com.bartex.classjobless4.ui.liked

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bartex.classjobless4.R

class LikedFragment: Fragment()  {

    private lateinit var likedViewModel: LikedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        likedViewModel =
            ViewModelProvider(this).get(LikedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_homeworks, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        likedViewModel.text.observe(viewLifecycleOwner,  {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().invalidateOptionsMenu()
    }
}