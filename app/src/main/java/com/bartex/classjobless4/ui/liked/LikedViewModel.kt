package com.bartex.classjobless4.ui.liked

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LikedViewModel:ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Это фрагмент Избранное"
    }
    val text: LiveData<String> = _text

}