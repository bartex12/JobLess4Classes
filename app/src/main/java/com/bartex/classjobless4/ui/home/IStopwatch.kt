package com.bartex.classjobless4.ui.home

interface IStopwatch {
    fun onStart()
    fun setOnTimeListener(listener: TimerExam.OnTimeListener)
}