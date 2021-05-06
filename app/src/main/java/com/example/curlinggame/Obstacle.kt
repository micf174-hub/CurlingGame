package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

open class Obstacle (val lepave: Pave) {
    var collision = Pave().ToucheObstacle()

    open fun interaction () {
        println("BIP")
        }
    }
    open class Obstaclec( var rayonO1: Float, val view: CurlingView) : Obstacle() {
        val ObstaclecPaint = Paint()
        val color1 = Color.GRAY
        var r1 = RectF(view.width/3, 2*view.height/3 , view.width/3 + rayonO1, 2*view.height/3 - rayonO1)

        override fun interaction() {
            lepave.Bouge()
        }
        fun draw(canvas: Canvas?) {
            ObstaclecPaint.color = color1
            canvas?.drawRect(r1, ObstaclecPaint)

        }

    }

    open class Obstacler( var rayonO2: Float, val view: CurlingView) : Obstacle() {
        val ObstaclerPaint = Paint()
        val color2 = Color.RED
        var r2 = RectF(2*view.width/3, 2*view.height/3, 2*view.width/3 + rayonO2, 2*view.height/3 - rayonO2)

        fun draw(canvas: Canvas?) {
            ObstaclerPaint.color = color2
            canvas?.drawOval(r2, ObstaclerPaint)
        }
    }

    open  class Obstacleg(var rayonO3: Float, val view: CurlingView) : Obstacle () {
        val ObstaclerPaint = Paint()
        val color3 = Color.BLUE
        val r3 = RectF(view.width /2, 2*view.height/3, view.width/2 + rayonO3, 2*view.height/3 + rayonO3)

        fun draw(canvas: Canvas?) {
            ObstaclerPaint.color = color3
            canvas?.drawOval(r3, ObstaclerPaint)
        }
    }

}