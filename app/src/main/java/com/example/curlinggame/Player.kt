package com.example.curlinggame

import android.graphics.*


class Player (var hauteur1: Float, var hauteur2 : Float, var hauteur : Float, val view : CurlingView) {

    val playerPaint = Paint()
    val playerPaint1 = Paint()
    val r = RectF(view.width / 2 - view.width / 10  , hauteur1, view.width / 2 + view.width / 10, view.height)
    val r1 = RectF(view.width / 2 - view.width / 20,hauteur2,view.width/2 + view.width / 20,hauteur1)
    var finCanon = PointF(hauteur1, hauteur2)

    fun draw(canvas: Canvas) {
        playerPaint.color = Color.BLACK
        playerPaint1.color = Color.BLACK
        canvas.drawRect(r, playerPaint)
        canvas.drawRect(r1, playerPaint1)
    }
    fun align(angle: Double) {
        finCanon.x = (hauteur2 * Math.sin(angle)).toFloat()
        finCanon.y = (-hauteur2 * Math.cos(angle)
                + view.height / 2).toFloat()
    }

    fun setRect() {
        r.set(view.width / 2 - view.width / 10 , hauteur1, view.width / 2+ view.width / 10 , view.height)
        r1.set(view.width / 2 - view.width / 20,hauteur2,view.width/2 + view.width / 20,hauteur1)
    }
}
