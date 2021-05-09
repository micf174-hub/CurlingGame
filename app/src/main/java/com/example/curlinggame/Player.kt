package com.example.curlinggame

import android.graphics.*


class Player (var hauteur1: Float, var hauteur2 : Float, var epaisseur : Float, val view : CurlingView) {

    val playerPaint = Paint()
    val r = RectF(view.width / 2 - view.width / 10  , hauteur1, view.width / 2 + view.width / 10, view.height)
    var r1 = PointF(view.width/2 + epaisseur, hauteur1)

    fun draw(canvas: Canvas) {
        playerPaint.color = Color.BLACK
        canvas.drawRect(r, playerPaint)
        playerPaint.strokeWidth = epaisseur * 1.5f
        canvas.drawLine(view.width/2 - epaisseur , hauteur2, r1.x,
                r1.y, playerPaint)
    }
    fun setRect() {
        r.set(view.width / 2 - view.width / 10 , hauteur1, view.width / 2+ view.width / 10 , view.height)
    }

    fun setr1() {
        r1.set(view.width/2 + epaisseur, hauteur1)
    }

    fun alignement(angle: Double) {
        r1.x = (-(hauteur1-hauteur2) * Math.sin(angle)).toFloat()
        r1.y = (-(hauteur1-hauteur2) * Math.cos(angle)).toFloat()
    }
}
