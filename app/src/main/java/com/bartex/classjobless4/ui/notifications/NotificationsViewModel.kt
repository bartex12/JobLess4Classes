package com.bartex.classjobless4.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Это фрагмент Домашки "
    }
    val text: LiveData<String> = _text
}