package com.example.curlinggame

import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF


class Player (var lsquareP: Float, var lsquareLP : Float, var view : CurlingView) {

    val playerPaint = Paint()
    val r = RectF(view.width / 2, lsquareP, view.width, 0f)
    val r1 = RectF(view.width / 2 , lsquareP + lsquareLP, view.width, lsquareP)
    val color = Color.BLACK

    fun draw(canvas: Canvas?) {
        playerPaint.color = color
        canvas?.drawRect(r, playerPaint)
        canvas?.drawRect(r1, playerPaint)
    }
}
