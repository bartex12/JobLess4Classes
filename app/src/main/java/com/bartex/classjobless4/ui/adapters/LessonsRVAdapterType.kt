package com.bartex.classjobless4.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Constsnts
import com.bartex.classjobless4.entity.Lessons
import com.squareup.picasso.Picasso

class LessonsRVAdapterType(
        private val onVideoClickListener: OnVideoClickListener
):RecyclerView.Adapter<BaseViewHolder>() {

    var listData:List<Lessons> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    interface OnVideoClickListener{
        fun onVideoClick(lesson:Lessons)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(viewType){
            Constsnts.TYPE_BASE -> {
                MainViewHolder(inflater.inflate(R.layout.item_lessons_base, parent, false))
            }
            Constsnts.TYPE_ADDITIONAL ->{
                AdditionalViewHolder(inflater.inflate(R.layout.item_lessons_additional, parent, false))
            }
            else -> {
                MainViewHolder(inflater.inflate(R.layout.item_lessons_base, parent, false))
            }
        }
    }

    //здесь описываем как различаем типы
    override fun getItemViewType(position: Int): Int {
        return when ( listData[position].isBase) {
            true -> Constsnts.TYPE_BASE
            else -> Constsnts.TYPE_ADDITIONAL
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
}