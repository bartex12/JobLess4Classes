package com.bartex.classjobless4.entity

import android.os.Parcel
import android.os.Parcelable

data class Lessons(
        val name: String? = "",
        val teacher: String? = "",
        val lessTime: String? = "",
        val isVideo:Boolean = false,
        val icon:Int = 0,
        val isBase:Boolean = true,
        val date:String? = "",
        val additionMatter:String = ""

        ): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(teacher)
        parcel.writeString(lessTime)
        parcel.writeByte(if (isVideo) 1 else 0)
        parcel.writeInt(icon)
        parcel.writeByte(if (isBase) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Lessons> {
        override fun createFromParcel(parcel: Parcel): Lessons {
            return Lessons(parcel)
        }

        override fun newArray(size: Int): Array<Lessons?> {
            return arrayOfNulls(size)
        }
    }
}
