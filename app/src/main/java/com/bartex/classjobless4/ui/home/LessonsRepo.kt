package com.bartex.classjobless4.ui.home

import android.app.Application
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Homework
import com.bartex.classjobless4.entity.Lessons

class LessonsRepo(val app:Application):ILessons {

    override fun getLessons(): List<Lessons> {
        return listOf(
            Lessons(
                name = "Физика", teacher = "Семён Семёныч ", date = "8:00-8:45",
                    isVideo = true, icon = R.drawable.physics, isBase = true
            ),
            Lessons(
                name = "История", teacher = "Мария Ивановна ", date = "9:00-9:45",
                    isVideo = false, icon = R.drawable.colosseum, isBase =true
            ),
            Lessons(
                name = "География", teacher = "Зинаида Афанасьевна ", date = "10:00-10:45",
                    isVideo = false, icon = R.drawable.globus160x160, isBase =true
            ),
            Lessons(
                name = "Литература", teacher = "Анна Петровна ", date = "11:00-11:45",
                    isVideo = true, icon = R.drawable.book170, isBase =true
            ),
            Lessons(
                name = "Алгебра", teacher = "Лидия Ивановна ", date = "12:00-12:45",
                    isVideo = false, icon = R.drawable.alg2, isBase =true
            ),
            Lessons(
                name = "Физкультура", teacher = "Александр Александрович", date = "13:00-13:45",
                    isVideo = false, icon = R.drawable.f2, isBase =false
            )
        )
    }

    override fun getHomeworks(): List<Homework> {
        return listOf(
            Homework(
                name = "Физика", daysLeft = 1,
                homework = app.resources.getString(R.string.hw_fisics), icon = R.drawable.physics
            ),
            Homework(
                name = "История", daysLeft = 2,
                homework = app.resources.getString(R.string.hw_history), icon = R.drawable.colosseum
            ),
            Homework(
                name = "География",
                daysLeft = 1,
                homework = app.resources.getString(R.string.hw_geo),
                icon = R.drawable.globus160x160
            ),
            Homework(
                name = "Литература", daysLeft = 5,
                homework = app.resources.getString(R.string.hw_lit), icon = R.drawable.book170
            ),
            Homework(
                name = "Алгебра", daysLeft = 2,
                homework = app.resources.getString(R.string.hw_alg), icon = R.drawable.alg2
            ),
            Homework(
                name = "Физкультура", daysLeft = 1,
                homework = app.resources.getString(R.string.hw_phisical), icon = R.drawable.f2
            )
        )

    }
}