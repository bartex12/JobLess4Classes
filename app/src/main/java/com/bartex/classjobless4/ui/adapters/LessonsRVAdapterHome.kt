package com.bartex.classjobless4.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Lessons
import com.squareup.picasso.Picasso

class LessonsRVAdapterHome(
        private val onItemClickListener: OnItemClickListener,
        private val onVideoClickListener: OnVideoClickListener,
        )
    :RecyclerView.Adapter<LessonsRVAdapterHome.ViewHolder>() {

    var listData: List<Lessons> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    interface OnItemClickListener{
        fun onItemClick()
    }
    interface OnVideoClickListener{
        fun onVideoClick(lesson:Lessons)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsRVAdapterHome.ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.item_lessons_home, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonsRVAdapterHome.ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
      return  listData.size
    }

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val lesson:TextView = view.findViewById(R.id.tvLesson)
        private val date:TextView = view.findViewById(R.id.tvTimeLesson)
        private val imageRound:ImageView = view.findViewById(R.id.iv_round)
        private val groupVideo:Group = view.findViewById(R.id.group_video)
        private val video:View = view.findViewById(R.id.ib_send)
        private val clClasses:View = view.findViewById(R.id.cl_slasses)

        fun bind(lessons: Lessons){
            lesson.text = lessons.name
            date.text = lessons.lessTime
            if(lessons.isVideo){
                groupVideo.visibility = View.VISIBLE
            }else{
                groupVideo.visibility = View.INVISIBLE
            }
            Picasso.get()
                    .load(lessons.icon)
                    .placeholder(R.drawable.post)
                    .error(R.drawable.mistake)
                    .into(imageRound)

            video.setOnClickListener {
                onVideoClickListener.onVideoClick(lessons)
            }

            clClasses.setOnClickListener {
                onItemClickListener.onItemClick()
            }
        }
    }
}