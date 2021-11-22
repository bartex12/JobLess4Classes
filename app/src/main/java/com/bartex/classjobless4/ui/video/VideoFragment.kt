package com.bartex.classjobless4.ui.video

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Constants
import com.bartex.classjobless4.entity.Lessons

class VideoFragment: Fragment()  {

    private lateinit var videoViewModel: VideoViewModel
    private lateinit var  textView: TextView
    private lateinit var  webView: WebView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view )

        val lessons:Lessons? = arguments?.getParcelable(Constants.CLASSES)
        lessons?.let{
            it.name?.let { it1 -> videoViewModel.setText(it1+ getString(R.string.videoLess) ) }
        }
        videoViewModel.text.observe(viewLifecycleOwner,  {
            textView.text = it
        })

        //1 - разрешение на internet    2 - подключение javaScript
        webView.settings.javaScriptEnabled = true
        lessons?. let{less->
            less.name?. let{name->
                when(name){
                   getString(R.string.fizika) -> {
                       webView.loadUrl(Constants.URL_FIZ)
                   }
                    getString(R.string.litra) -> {
                        webView.loadUrl(Constants.URL_LITRA)
                    }
                    else -> {
                        webView.loadUrl(Constants.URL_NONE)
                    }
                }
            }
        }

    }

    private fun initView(view: View) {
        videoViewModel = ViewModelProvider(this)[VideoViewModel::class.java]
        textView = view.findViewById(R.id.text_video)
        webView = view.findViewById(R.id.webView)

    }
}