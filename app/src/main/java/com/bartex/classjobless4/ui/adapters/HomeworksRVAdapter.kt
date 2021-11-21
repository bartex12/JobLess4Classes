package com.bartex.classjobless4.ui.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Homework
import com.squareup.picasso.Picasso
import java.util.*

class HomeworksRVAdapter:RecyclerView.Adapter<HomeworksRVAdapter.ViewHolder>() {
    lateinit var  context: Context

    var listHw: List<Homework> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeworksRVAdapter.ViewHolder {
        context = parent.context
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_homework, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeworksRVAdapter.ViewHolder, position: Int) {
        holder.bind(listHw[position])
    }

    override fun getItemCount(): Int {
        return  listHw.size
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val lesson: TextView = view.findViewById(R.id.tvLessonHw)
        private val daysLast: TextView = view.findViewById(R.id.tvTimeLessonHw)
        private val imageRound: ImageView = view.findViewById(R.id.iv_roundHw)
        private val hw: TextView = view.findViewById(R.id.tvHomeworkHw)

        fun bind(homework: Homework){
            lesson.text = homework.name
            daysLast.text = String.format(Locale.getDefault(),
                context.resources.getString(R.string.left_days), homework.daysLeft)
            if(homework.daysLeft<2){
                daysLast.setTextColor(Color.YELLOW)
            }else{
                daysLast.setTextColor(Color.WHITE)
            }
            hw.text = homework.homework
            Picasso.get()
                .load(homework.icon)
                .placeholder(R.drawable.post)
                .error(R.drawable.mistake)
                .into(imageRound)
        }
    }
}