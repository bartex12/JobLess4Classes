package com.bartex.classjobless4.ui.home

interface ITimerExam {
    fun onStart()
    fun setOnTimeListener(listener: MyTimerExam.OnTimeListener)
}