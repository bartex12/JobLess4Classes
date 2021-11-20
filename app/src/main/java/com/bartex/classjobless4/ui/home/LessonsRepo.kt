package com.bartex.classjobless4.ui.home

import android.app.Application
import androidx.core.content.ContextCompat
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Homework
import com.bartex.classjobless4.entity.Lessons

class LessonsRepo(val app:Application):ILessons {

    override fun getLessons(): List<Lessons> {
        return listOf(
            Lessons(
                name = "Физика", date = "8:00-8:45",
                true, icon = R.drawable.physics
            ),
            Lessons(
                name = "История", date = "9:00-9:45",
                false, icon = R.drawable.colosseum
            ),
            Lessons(
                name = "География", date = "10:00-10:45",
                false, icon = R.drawable.globus160x160
            ),
            Lessons(
                name = "Литература", date = "11:00-11:45",
                true, icon = R.drawable.book170
            ),
            Lessons(
                name = "Алгебра", date = "12:00-12:45",
                false, icon = R.drawable.alg2
            ),
            Lessons(
                name = "Физкультура", date = "13:00-13:45",
                false, icon = R.drawable.f2
            )
        )
    }

    override fun getHomeworks(): List<Homework> {
        return listOf(
            Homework(
                name = "Физика", daysLeft = 2,
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