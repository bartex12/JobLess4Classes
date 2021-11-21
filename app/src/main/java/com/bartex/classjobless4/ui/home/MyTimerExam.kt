package com.bartex.classjobless4.ui.home

import android.app.Application
import android.os.CountDownTimer
import com.bartex.classjobless4.entity.Constsnts

class MyTimerExam(val app:Application):ITimerExam {

    var listener: OnTimeListener? = null
    var totalTime = Constsnts.START_TIME
    var kvant = Constsnts.KVANT

    interface OnTimeListener{
        fun onTime(time: Long)
    }
    override fun setOnTimeListener(listener: OnTimeListener) {
        this.listener = listener
    }

    override fun onStart() {
        MyTimer().start()
    }

    inner class MyTimer : CountDownTimer(totalTime, kvant) {
        override fun onTick(p0: Long) {
            listener?.onTime(p0)
        }
        override fun onFinish() {
            listener?.onTime(0)
        }
    }
}