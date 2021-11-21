package com.bartex.classjobless4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel( ) {

    val time = MutableLiveData<Long>()

    fun getTime():LiveData<Long>{
        return time
    }
}