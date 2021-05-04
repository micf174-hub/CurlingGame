package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import java.util.*

class Cible (var x1 : Float, var y1 : Float, var rayonC : Float) {
    val random = Random()
    val ciblePaint = Paint()
    val r = RectF(x1, y1, x1 + (2 * rayonC), y1 - (2 * rayonC))

    fun rand(from: Int, to: Int): Int {
        return random.nextInt(to - from) + from
    }

    fun draw(canvas: Canvas) {
        val NB_R = rand(0, 2)
        var NB_C = 0
        while (NB_C < 10) {
            NB_C++
            if (NB_R == 0) {
                ciblePaint.color = Color.YELLOW
                canvas.drawRect(r, ciblePaint)
                canvas.drawText("5", x1, y1, ciblePaint)
            }
            else if (NB_R == 1) {
                ciblePaint.color = Color.RED
                canvas.drawRect(r, ciblePaint)
                canvas.drawText("10", x1, y1, ciblePaint)
            }
            else if (NB_R == 2) {
                ciblePaint.color = Color.BLACK
                canvas.drawOval(r, ciblePaint)
                canvas.drawText("10", x1, y1, ciblePaint)
            }
        }
    }
}