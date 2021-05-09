package com.example.curlinggame

import android.graphics.*
import java.util.*

class Pave (var rayonP : Float, var hauteur : Float, val view : CurlingView) {
    val random = Random()
    val pavePaint = Paint()
    val r = RectF(view.width/2-10f, hauteur, view.width/2+10f,0f)
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    fun draw(canvas: Canvas?) {
        pavePaint.color = color
        canvas?.drawOval(r, pavePaint)
    }

    fun setRect() {
        r.set(view.width/2-10f, hauteur, view.width/2+10f,0f)
    }
}