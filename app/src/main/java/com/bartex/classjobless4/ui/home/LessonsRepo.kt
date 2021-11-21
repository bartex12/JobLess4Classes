package com.bartex.classjobless4.ui.home

import android.app.Application
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Homework
import com.bartex.classjobless4.entity.Lessons
import java.lang.String
import java.util.*

class LessonsRepo(val app: Application):ILessons {

    override fun getLessons(): List<Lessons> {
        val calendar = GregorianCalendar()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val date = String.format(Locale.getDefault(),"%02d.%02d.%04d",day, month + 1, year)

        return listOf(
                Lessons(
                        name = "Физика", teacher = "Семён Семёныч ", lessTime = "8:00-8:45",
                        isVideo = true, icon = R.drawable.physics, isBase = true, date = date
                ),
                Lessons(
                        name = "История", teacher = "Мария Ивановна ", lessTime = "9:00-9:45",
                        isVideo = false, icon = R.drawable.colosseum, isBase = true, date = date
                ),
                Lessons(
                        name = "География", teacher = "Зинаида Афанасьевна ", lessTime = "10:00-10:45",
                        isVideo = false, icon = R.drawable.globus160x160, isBase = true, date = date
                ),
                Lessons(
                        name = "Литература", teacher = "Анна Петровна ", lessTime = "11:00-11:45",
                        isVideo = true, icon = R.drawable.book170, isBase = true, date = date
                ),
                Lessons(
                        name = "Алгебра", teacher = "Лидия Ивановна ", lessTime = "12:00-12:45",
                        isVideo = false, icon = R.drawable.alg2, isBase = true, date = date
                ),
                Lessons(
                        name = "Физкультура", teacher = "Александр Александрович", lessTime = "13:00-13:45",
                        isVideo = false, icon = R.drawable.f2, isBase = false, date = date,
                        additionMatter = app.resources.getString(R.string.hw_phisical_add)
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