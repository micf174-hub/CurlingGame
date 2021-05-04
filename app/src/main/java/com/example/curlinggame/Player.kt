package com.example.curlinggame
import CurlingView
import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF


class Player (var lsquareP: Float, var lsquareLP : Float, val view : CurlingView) {

    val playerPaint = Paint()
    val r = RectF(view.width / 2 - 10f, lsquareP, view.width / 2 + 10f, 0f)
    val r1 = RectF(view.width / 2 - 5f, lsquareP + lsquareLP, view.width / 2 + 5f, lsquareP)
    val color = Color.BLACK

    fun draw(canvas: Canvas) {
        playerPaint.color = color
        canvas.drawRect(r, playerPaint)
        canvas.drawRect(r1, playerPaint)
    }
}
