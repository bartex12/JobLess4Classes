package com.bartex.classjobless4.ui.home

import androidx.lifecycle.ViewModel
import com.bartex.classjobless4.App
import com.bartex.classjobless4.entity.Homework
import com.bartex.classjobless4.entity.Lessons

class HomeViewModel(
        private var timeRepo: IStopwatch = TimerExam(),
        private var lessonsRepo: ILessons = LessonsRepo(app = App.instance),
) : ViewModel() {

   fun onStartTimer(){
       timeRepo.onStart()
   }

    fun setOnTimeListener(listener: TimerExam.OnTimeListener){
        timeRepo.setOnTimeListener(listener)
    }

    fun getLessons():List<Lessons>{
       return lessonsRepo.getLessons()
    }

    fun getHomeworks():List<Homework>{
        return lessonsRepo.getHomeworks()
    }
}