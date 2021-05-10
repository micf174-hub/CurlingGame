package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleR( var rayon2: Float ,var vO1Init : Float,val view : CurlingView,var cible: Cible) {
    val obstacleRPaint = Paint()
    val r2 = RectF(view.width / 2 - view.width / 10, view.height / 2, view.width / 2 + view.width / 10, view.height / 2 + rayon2)
    var vO1 = vO1Init

    fun draw(canvas: Canvas?) {
        obstacleRPaint.color = Color.RED
        canvas?.drawCircle(view.width / 2, view.height / 2, rayon2, obstacleRPaint)
    }

    fun setRect() {
        r2.set(
                view.width / 2 - view.width / 10, view.height / 2, view.width / 2 + view.width / 10, view.height / 2 + rayon2)
    }

    fun ChocO2(pave: Pave) {
        pave.resetPave()

    }

    fun update(interval: Double) {
        var up = (interval * vO1).toFloat()
        r2.offset(up, 0f)
        if (r2.left < 0 || r2.right > view.width) {
            vO1 *= -1
            up = (interval * 3 * vO1).toFloat()
            r2.offset(up, 0f)
        }

    }
}