package com.example.curlinggame

import android.graphics.*


class Player(var lsquareP: Float, var lsquareLP: Float, var hauteur: Float, val view: CurlingView) {

    val playerPaint = Paint()
    val r = RectF(view.width / 2 - view.width/10, lsquareP, view.width / 2 + view.width/10, 0f)
    val r1 = RectF(view.width / 2 - view.width/20, lsquareP + lsquareLP, view.width / 2 + view.width/20, lsquareP)
    val color = Color.BLACK
    var finCanon = PointF(lsquareP, hauteur)


    fun draw(canvas: Canvas) {
        playerPaint.color = color
        canvas.drawRect(r, playerPaint)
        canvas.drawRect(r1, playerPaint)
    }
    fun align(angle: Double) {
        finCanon.x = (lsquareLP * Math.sin(angle)).toFloat()
        finCanon.y = (-lsquareLP * Math.cos(angle)
                + view.height / 2).toFloat()
    }
}

