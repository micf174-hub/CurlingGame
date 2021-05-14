package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF


open class Obstacle (var vitesseO : Float, var rayonO : Float ) {

    var obstaclePaint = Paint()
    var r = RectF(0f,0f,0f,0f)

    open fun draw(canvas: Canvas?) {
        obstaclePaint.color = Color.BLACK
        canvas?.drawRect(r, obstaclePaint)
    }
    open fun update(interval: Double) {
        var vO1 = vitesseO
        var up = (interval * vO1).toFloat()
        r.offset(up, 0f)
        if (r.left < r.left -30f || r.right > r.right + 30f) {
            vO1 *= -1
            up = (interval * vO1).toFloat()
            r.offset(up, 0f)
        }

    }

    open fun setRect(){
        r.set(r.left,r.top,r.right,r.bottom)

    }
}