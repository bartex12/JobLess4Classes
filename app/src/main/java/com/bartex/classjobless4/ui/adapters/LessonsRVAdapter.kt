package com.bartex.classjobless4.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Constants
import com.bartex.classjobless4.entity.Lessons
import com.squareup.picasso.Picasso

class LessonsRVAdapter(
        private val onItemClickListener: OnItemClickListener,
        private val onVideoClickListener: OnVideoClickListener,
        private val isHomeFragment: Boolean
):RecyclerView.Adapter<BaseViewHolder>() {

    var listData:List<Lessons> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    interface OnVideoClickListener{
        fun onVideoClick(lesson:Lessons)
    }

    interface OnItemClickListener{
        fun onItemClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if(isHomeFragment){
            HomeViewHolder(inflater.inflate(R.layout.item_lessons_home, parent, false))
        }else{
            when(viewType){
                Constants.TYPE_BASE -> {
                    MainViewHolder(inflater.inflate(R.layout.item_lessons_base, parent, false))
                }
                Constants.TYPE_ADDITIONAL ->{
                    AdditionalViewHolder(inflater.inflate(R.layout.item_lessons_additional, parent, false))
                }
                Constants.TYPE_HOME_FRAG ->{
                    HomeViewHolder(inflater.inflate(R.layout.item_lessons_home, parent, false))
                }
                else -> {
                    MainViewHolder(inflater.inflate(R.layout.item_lessons_base, parent, false))
                }
            }
        }
    }

    //здесь описываем как различаем типы
    override fun getItemViewType(position: Int): Int {
        return if(isHomeFragment){
            Constants.TYPE_HOME_FRAG
        }else{
            when ( listData[position].isBase) {
                true -> Constants.TYPE_BASE
                else -> Constants.TYPE_ADDITIONAL
            }
        }
    }

    override fun onBindViewHolder(holderBase: BaseViewHolder, position: Int) {
        holderBase.bind(listData[position])
    }

    override fun getItemCount(): Int  = listData.size

   inner class MainViewHolder(view: View) :BaseViewHolder(view){
        private val time: TextView = view.findViewById(R.id.tvTimeType)
        private val name: TextView = view.findViewById(R.id.tv_name_type)
        private val teacher: TextView = view.findViewById(R.id.tv_teacher_type)
        private val imageRound: ImageView = view.findViewById(R.id.iv_round_type)
        private val groupVideo: Group = view.findViewById(R.id.group_video_type)
        private val video:View = view.findViewById(R.id.ib_send_type)

        override fun bind(lesson:Lessons){
            time.text =lesson.lessTime
            name.text = lesson.name
            teacher.text = lesson.teacher
            if(lesson.isVideo){
                groupVideo.visibility = View.VISIBLE
            }else{
                groupVideo.visibility = View.INVISIBLE
            }

            Picasso.get()
                    .load(lesson.icon)
                    .placeholder(R.drawable.post)
                    .error(R.drawable.mistake)
                    .into(imageRound)

            video.setOnClickListener {
                onVideoClickListener.onVideoClick(lesson)
            }
        }
    }

    inner class AdditionalViewHolder(view: View) :BaseViewHolder(view){
        private val time: TextView = view.findViewById(R.id.tvTimeType_add)
        private val name: TextView = view.findViewById(R.id.tvLessonHw_add)
        private val teacher: TextView = view.findViewById(R.id.tv_teacher_add)
        private val hw: TextView = view.findViewById(R.id.tvHomeworkHw_add)
        private val imageRound: ImageView = view.findViewById(R.id.iv_roundHw_add)

        override fun bind(lesson: Lessons) {
            time.text =lesson.lessTime
            name.text = lesson.name
            teacher.text = lesson.teacher
            hw.text = lesson.additionMatter

            Picasso.get()
                    .load(lesson.icon)
                    .placeholder(R.drawable.post)
                    .error(R.drawable.mistake)
                    .into(imageRound)
        }
    }

    inner class HomeViewHolder(view: View) :BaseViewHolder(view){
        private val lesson:TextView = view.findViewById(R.id.tvLesson)
        private val date:TextView = view.findViewById(R.id.tvTimeLesson)
        private val imageRound:ImageView = view.findViewById(R.id.iv_round)
        private val groupVideo:Group = view.findViewById(R.id.group_video)
        private val video:View = view.findViewById(R.id.ib_send)
        private val clClasses:View = view.findViewById(R.id.cl_slasses)

        override fun bind(lesson: Lessons) {
            this.lesson.text = lesson.name
            date.text = lesson.lessTime
            if(lesson.isVideo){
                groupVideo.visibility = View.VISIBLE
            }else{
                groupVideo.visibility = View.INVISIBLE
            }
            Picasso.get()
                    .load(lesson.icon)
                    .placeholder(R.drawable.post)
                    .error(R.drawable.mistake)
                    .into(imageRound)

            video.setOnClickListener {
                onVideoClickListener.onVideoClick(lesson)
            }

            clClasses.setOnClickListener {
                onItemClickListener.onItemClick()
            }
        }
    }
}