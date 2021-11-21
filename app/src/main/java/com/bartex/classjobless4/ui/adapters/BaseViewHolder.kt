package com.bartex.classjobless4.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bartex.classjobless4.entity.Lessons

abstract class BaseViewHolder(view: View):RecyclerView.ViewHolder(view) {
    abstract fun bind(lesson:Lessons)
}