package com.example.curlinggame

import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF


class Player (var lsquareP: Float, var lsquareLP : Float, val view : CurlingView) {

    val playerPaint = Paint()
    val playerPaint1 = Paint()
    val r = RectF(view.width / 2 - view.width / 10  , lsquareP, view.width / 2 + view.width / 10, view.height)
    val r1 = RectF(view.width / 2 - view.width / 20,lsquareLP,view.width/2 + view.width / 20,lsquareP)

    fun draw(canvas: Canvas) {
        playerPaint.color = Color.BLACK
        playerPaint1.color = Color.BLACK
        canvas.drawRect(r, playerPaint)
        canvas.drawRect(r1, playerPaint1)
    }

    fun setRect() {
        r.set(view.width / 2 - view.width / 10 , lsquareP, view.width / 2+ view.width / 10 , view.height)
        r1.set(view.width / 2 - view.width / 20,lsquareLP,view.width/2 + view.width / 20,lsquareP)
    }
}
