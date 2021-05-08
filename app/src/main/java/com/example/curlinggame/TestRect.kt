package com.example.curlinggame


import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class TestRect (var obstacleDistance: Float, var obstacleDebut: Float, var obstacleFin: Float, var initialObstacleVitesse: Float, var width: Float, var view: CurlingView)
{
    val obstacle = RectF(obstacleDistance, obstacleDebut,
        obstacleDistance + width, obstacleFin)
    val obstaclePaint = Paint()
    var obstacleVitesse= initialObstacleVitesse

    fun setRect() {
        obstacle.set(obstacleDistance, obstacleDebut,
            obstacleDistance + width, obstacleFin)
        obstacleVitesse= initialObstacleVitesse
    }


    fun draw(canvas: Canvas) {
        obstaclePaint.color = Color.RED
        canvas.drawRect(obstacle, obstaclePaint)
    }
}