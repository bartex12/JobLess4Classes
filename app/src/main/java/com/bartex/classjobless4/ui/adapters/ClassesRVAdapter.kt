package com.bartex.classjobless4.ui.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.bartex.classjobless4.R
import com.bartex.classjobless4.entity.Lessons
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation


class ClassesRVAdapter(
        private val onItemClickListener: OnItemClickListener,
        private val onVideoClickListener: OnVideoClickListener,

        )
    :RecyclerView.Adapter<ClassesRVAdapter.ViewHolder>() {

    lateinit var  context: Context
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesRVAdapter.ViewHolder {
        context = parent.context
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_classes, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClassesRVAdapter.ViewHolder, position: Int) {
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
        private val groupClasses:View = view.findViewById(R.id.group_classes)
        private val clClasses:View = view.findViewById(R.id.cl_slasses)



        fun bind(lessons: Lessons){
            lesson.text = lessons.name
            date.text = lessons.date
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

//            imageRound.setOnClickListener {
//                onItemClickListener.onItemClick()
//            }

            video.setOnClickListener {
                onVideoClickListener.onVideoClick(lessons)
            }

            clClasses.setOnClickListener {
                onItemClickListener.onItemClick()
            }
        }

    }
}