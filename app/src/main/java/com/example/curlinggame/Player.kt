package com.example.curlinggame

import android.graphics.*


class Player (var hauteur1: Float, var hauteur2 : Float, var largeur : Float, var epaisseur : Float, val view : CurlingView) {

    val playerPaint = Paint()
    val r = RectF(view.width / 2 - view.width / 10  , hauteur1, view.width / 2 + view.width / 10, view.height)
    var r1 = PointF(largeur, hauteur2)

    fun draw(canvas: Canvas) {
        playerPaint.color = Color.BLACK
        canvas.drawRect(r, playerPaint)
        playerPaint.strokeWidth = epaisseur * 1.5f
        canvas.drawLine(view.width/2 , hauteur1, r1.x,
                r1.y, playerPaint)
    }
    fun setRect() {
        r.set(view.width / 2 - view.width / 10 , hauteur1, view.width / 2 + view.width / 10 , view.height)
    }

    fun setr1(hauteur2: Float) {
        r1.set(largeur, hauteur2)
    }

    fun alignement(angle: Double) {
        r1.x = (view.width/2 + hauteur1* Math.sin(angle)).toFloat()
        r1.y = (hauteur1 - hauteur1 * Math.cos(angle)).toFloat()
    }
}
