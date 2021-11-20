package com.bartex.classjobless4.ui.home

import com.bartex.classjobless4.entity.Homework
import com.bartex.classjobless4.entity.Lessons

interface ILessons {
    fun getLessons():List<Lessons>
    fun getHomeworks():List<Homework>
}