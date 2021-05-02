package com.example.curlinggame

import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.PointF
import com.example.curlinggame.CurlingView

class Player (var canonBaseRadius: Float, var canonLongueur: Float, hauteur: Float, var largeur: Float, val view: CurlingView) {
    val curlingPaint = Paint()
    var finCanon = PointF(canonLongueur, hauteur)
    fun draw(canvas: Canvas) {
        canonPaint.strokeWidth = largeur * 1.5f
        canvas.drawLine(0f, view.screenHeight/2, finCanon.x,
            finCanon.y, canonPaint)
        canvas.drawCircle(0f, view.screenHeight/2, canonBaseRadius,
            canonPaint)
    }
    fun setFinCanon(hauteur: Float) {
        finCanon.set(canonLongueur, hauteur)
    }
}
