package com.bartex.classjobless4.ui.home

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable


class RoundedImageView(context: Context):  androidx.appcompat.widget.AppCompatImageView(context) {

    private val rect = Rect()

    override fun onDraw(canvas: Canvas) {
        val drawable = drawable ?: return
        if (width == 0 || height == 0) {
            return
        }
        val b = (drawable as BitmapDrawable).bitmap
        val bitmap = b.copy(Bitmap.Config.ARGB_8888, true)
        val w = width
        val h = height
        val roundBitmap = getCroppedBitmap(bitmap, w)
        canvas.drawBitmap(roundBitmap, rect, rect, null)
    }

    private fun getCroppedBitmap(bmp: Bitmap, radius: Int): Bitmap {
        val sbmp: Bitmap = if (bmp.width != radius || bmp.height != radius) {
            val smallest = Math.min(bmp.width, bmp.height).toFloat()
            val factor = smallest / radius
            Bitmap.createScaledBitmap(bmp, (bmp.width / factor).toInt(), (bmp.height / factor).toInt(), false)
        } else {
            bmp
        }
        val output = Bitmap.createBitmap(radius, radius,
                Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val color = -0x5e688c
        val paint = Paint()
        val rect = Rect(0, 0, radius, radius)
        paint.isAntiAlias = true
        paint.isFilterBitmap = true
        paint.isDither = true
        canvas.drawARGB(0, 0, 0, 0)
        paint.color = Color.parseColor("#BAB399")
        canvas.drawCircle(radius / 2 + 0.7f,
                radius / 2 + 0.7f, radius / 2 + 0.1f, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(sbmp, rect, rect, paint)
        return output
    }
}