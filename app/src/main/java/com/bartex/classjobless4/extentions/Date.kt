package com.bartex.classjobless4.extentions

import java.text.SimpleDateFormat
import java.util.*

fun Date.format(pattern:String = "dd.MM.yyyy"):String{
    val dateFormat:SimpleDateFormat =  SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(this)
}