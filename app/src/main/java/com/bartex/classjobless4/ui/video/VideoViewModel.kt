package com.bartex.classjobless4.ui.video

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VideoViewModel : ViewModel(){
    private val _text = MutableLiveData<String>().apply {
        value = "Это фрагмент Домашки "
    }

    val text: LiveData<String> = _text

    fun setText(text:String){
        _text.value = text
    }
}