package com.example.curlinggame

import android.graphics.*
import java.util.*

class Pave (var rayonP : Float, var hauteur : Float, val view : CurlingView) {
    val random = Random()
    val pavePaint = Paint()
    val r = RectF(view.width/2-10f, hauteur, view.width/2+10f,0f)
    fun draw(canvas: Canvas?) {
        pavePaint.color = Color.RED
        canvas?.drawOval(r, pavePaint)
    }

    fun setRect() {
        r.set(view.width/2-10f, hauteur, view.width/2+10f,0f)
    }
}