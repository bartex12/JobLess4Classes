package com.bartex.classjobless4.ui.classes

import androidx.lifecycle.ViewModel
import com.bartex.classjobless4.App
import com.bartex.classjobless4.entity.Lessons
import com.bartex.classjobless4.ui.home.ILessons
import com.bartex.classjobless4.ui.home.LessonsRepo

class LessonsViewModel(
        private var lessonsRepo: ILessons = LessonsRepo(app = App.instance)) : ViewModel()
{
    fun getLessons():List<Lessons>{
        return lessonsRepo.getLessons()
    }
}