package com.example.curlinggame
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import java.util.*

class Pave (var x1 : Float, var y1 : Float, var rayonP : Float) {
    val random = Random()
    val pavePaint = Paint()
    val r = RectF(x1, y1, x1 + (2 * rayonP), y1 + (2 * rayonP))
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))

    fun draw(canvas: Canvas?) {
        pavePaint.color = color
        canvas?.drawOval(r, pavePaint)
    }
}