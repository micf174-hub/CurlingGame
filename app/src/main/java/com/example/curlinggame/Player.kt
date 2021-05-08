package com.example.curlinggame

import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF


class Player (var lsquareP: Float, var lsquareLP : Float, var view : CurlingView) {

    val playerPaint = Paint()
    val r = RectF(view.width , lsquareP, view.width/2, 0f)
    val r1 = RectF(view.width  , lsquareP + lsquareLP, view.width/2, lsquareP)
    val color = Color.BLACK

    fun draw(canvas: Canvas?) {
        playerPaint.color = color
        canvas?.drawRect(r, playerPaint)
        canvas?.drawRect(r1, playerPaint)
    }
    fun setRect() {
        r.set(view.width , lsquareP, view.width/2, 0f)
    }
}
