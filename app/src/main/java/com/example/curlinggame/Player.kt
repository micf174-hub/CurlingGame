package com.example.curlinggame

import android.graphics.Paint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.RectF


class Player (var hauteur1: Float, var hauteur2 : Float, val view : CurlingView) {

    val playerPaint = Paint()
    val playerPaint1 = Paint()
    val r = RectF(view.width / 2 - view.width / 10  , hauteur1, view.width / 2 + view.width / 10, view.height)
    val r1 = RectF(view.width / 2 - view.width / 20,hauteur2,view.width/2 + view.width / 20,hauteur1)

    fun draw(canvas: Canvas) {
        playerPaint.color = Color.BLACK
        playerPaint1.color = Color.BLACK
        canvas.drawRect(r, playerPaint)
        canvas.drawRect(r1, playerPaint1)
    }

    fun setRect() {
        r.set(view.width / 2 - view.width / 10 , hauteur1, view.width / 2+ view.width / 10 , view.height)
        r1.set(view.width / 2 - view.width / 20,hauteur2,view.width/2 + view.width / 20,hauteur1)
    }
}
