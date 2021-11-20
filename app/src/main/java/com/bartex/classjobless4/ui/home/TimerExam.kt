package com.bartex.classjobless4.ui.home

import android.os.CountDownTimer

class TimerExam:IStopwatch {

    companion object{
      const val START_TIME  = 10*24*3600*1000L //10 дней в мс
    }

    var listener: OnTimeListener? = null

    interface OnTimeListener{
        fun onTime(time: Long)
    }

    override fun setOnTimeListener(listener: OnTimeListener) {
        this.listener = listener
    }

    override fun onStart() {
        MyTimer().start()
    }

    inner class MyTimer : CountDownTimer(START_TIME, 1000) {

        override fun onTick(p0: Long) {
            listener?.onTime(p0)
        }

        override fun onFinish() {
            listener?.onTime(0)
        }
    }
}