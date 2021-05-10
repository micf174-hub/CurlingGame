package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleR(var rayon2: Float, view : CurlingView) : Obstacle(rayon2, view) {
    val obstacleRPaint = Paint()
    val r2 = RectF(
            view.width/2 - view.width/10,
            view.height/2,
            view.width/2 + view.width/10,
            view.height/2 + rayon2
    )

    fun draw(canvas: Canvas?) {
        obstacleRPaint.color = Color.RED
        canvas?.drawCircle(view.width/2,view.height/2,rayon2, obstacleRPaint)
    }

    override fun interaction (){

    }

    fun setRect() {
        r2.set(
                view.width/2 - view.width/10,
                view.height/2,
                view.width/2 + view.width/10,
                view.height/2 + rayon2
        )
    }
}