package com.example.curlinggame

import android.graphics.*
import java.util.*

class Pave (var rayonP : Float, var hauteur : Float, val view : CurlingView) {
    val random = Random()
    val pavePaint = Paint()
    val r = RectF(view.width/2-rayonP, hauteur, view.width/2 + rayonP,view.height)
    fun draw(canvas: Canvas?) {
        pavePaint.color = Color.RED
        canvas?.drawOval(r, pavePaint)
    }

    fun setRect() {
        r.set(view.width/2-rayonP, hauteur, view.width/2 + rayonP,view.height)
    }
}