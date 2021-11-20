package com.bartex.classjobless4.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Это фрагмент Уроки"
    }
    val text: LiveData<String> = _text
}