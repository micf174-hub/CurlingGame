package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleR( val view: CurlingView) : Obstacle(view.width/10f,view.width/10f) {

    var r1 = RectF(view.width / 2 - view.width / 10, view.height / 2, view.width / 2 + view.width / 10, view.height / 2 + rayonO)
    override fun draw(canvas: Canvas?) {
        val obstaclePaint = Paint()
        obstaclePaint.color = Color.RED
        canvas?.drawCircle(view.width / 2, view.height / 2, rayonO, obstaclePaint)
    }

    override fun setRect() {
        r1.set(view.width / 2 - view.width / 10, view.height / 2, view.width / 2 + view.width / 10, view.height / 2 + rayonO)
    }

    override fun update(interval: Double) {
        var vO1 = vitesseO
        var up = (interval * vO1).toFloat()
        r1.offset(0f, up)
        if (r1.top < r1.top +30f || r1.bottom > r1.bottom - 30f) {
            vO1 *= -1
            up = (interval * vO1).toFloat()
            r1.offset(0f, up)
        }
    }
}