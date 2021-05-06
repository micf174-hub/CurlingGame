package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class Obstacle () {

    class Obstaclec( var rayonO1: Float, val view: CurlingView) {
        val ObstaclecPaint = Paint()
        val color1 = Color.GRAY
        val r1 = RectF(view.width/3, 2*view.height/3 , view.width/3 + rayonO1, 2*view.height/3 - rayonO1)

        fun draw(canvas: Canvas?) {
            ObstaclecPaint.color = color1
            canvas?.drawRect(r1, ObstaclecPaint)

        }
    }

    class Obstacler( var rayonO2: Float, val view: CurlingView) {
        val ObstaclerPaint = Paint()
        val color2 = Color.RED
        val r2 = RectF(0f, view.height/2, rayonO2, view.height/2 - rayonO2)

        fun draw(canvas: Canvas?) {
            ObstaclerPaint.color = color2
            canvas?.drawOval(r2, ObstaclerPaint)
        }
    }

    class Obstacleg(var rayonO3: Float, val view: CurlingView) {
        val ObstaclerPaint = Paint()
        val color3 = Color.BLUE
        val r3 = RectF(x1, y1, x1 + (2 * rayonO2), y1 - (2 * rayonO2))

        fun draw(canvas: Canvas?) {
            ObstaclerPaint.color = color3
            canvas?.drawOval(r3, ObstaclerPaint)
        }
    }

}