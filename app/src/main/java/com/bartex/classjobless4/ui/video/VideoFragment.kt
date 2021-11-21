package com.bartex.classjobless4.ui.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Constsnts
import com.bartex.classjobless4.entity.Lessons

class VideoFragment: Fragment()  {

    private lateinit var videoViewModel: VideoViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        videoViewModel = ViewModelProvider(this)[VideoViewModel::class.java]
        val textView: TextView = view.findViewById(R.id.text_video)

        val lessons:Lessons? = arguments?.getParcelable(Constsnts.CLASSES)
        lessons?.let{
            it.name?.let { it1 -> videoViewModel.setText(it1+ getString(R.string.videoLess) ) }
        }

        videoViewModel.text.observe(viewLifecycleOwner,  {
            textView.text = it
        })
    }
}