package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleC(var rayon1: Float, val view: CurlingView) : Obstacle() {
    val obstacleCPaint = Paint()
    val r1 = RectF(
            view.width / 4 - rayon1,
            view.height/2 - rayon1,
            view.width / 4 + rayon1,
            view.height / 2 + rayon1
        )

    fun draw(canvas: Canvas?) {
        obstacleCPaint.color = Color.BLUE
        canvas?.drawRect(r1, obstacleCPaint)
    }

    fun setRect() {
        r1.set(view.width / 4 - rayon1,
            view.height/2 - rayon1,
            view.width / 4 + rayon1,
            view.height / 2 + rayon1
                )
    }

    fun update(interval: Double){
        obstacleCPaint.color = Color.YELLOW
    }

    open fun paveCadeau(){
        view.viesRestantes +=1
    }
}