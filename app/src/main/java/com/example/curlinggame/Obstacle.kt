package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

open class Obstacle () {

    class Obstaclec(var x1: Float, var y1: Float, var rayonO1: Float) {
        val ObstaclecPaint = Paint()
        val color1 = Color.GRAY
        val r1 = RectF(x1, y1, x1 + (2 * rayonO1), y1 - (2 * rayonO1))

        fun draw(canvas: Canvas?) {
            ObstaclecPaint.color = color1
            canvas?.drawRect(r1, ObstaclecPaint)

        }
        fun setRect() {
            r.set()

    class Obstacler(var x1: Float, var y1: Float, var rayonO2: Float) {
        val ObstaclerPaint = Paint()
        val color2 = Color.RED
        val r2 = RectF(x1, y1, x1 + (2 * rayonO2), y1 - (2 * rayonO2))

        fun draw(canvas: Canvas?) {
            ObstaclerPaint.color = color2
            canvas?.drawOval(r2, ObstaclerPaint)
        }
        fun setRect() {
            r.set()


        }


}