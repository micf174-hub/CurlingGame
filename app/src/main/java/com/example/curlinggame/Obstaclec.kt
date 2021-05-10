package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleC(var rayon1: Float, view: CurlingView) : Obstacle(rayon1, view) {
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

    override fun interaction (){

    }

    fun setRect() {
        r1.set(view.width / 4 - rayon1,
            view.height/2 - rayon1,
            view.width / 4 + rayon1,
            view.height / 2 + rayon1
                )
    }

    }