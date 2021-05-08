package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

open class TestRect(var view: CurlingView) {
    val TestPaint = Paint()
    val r1 = RectF(0f, 0f,  view.width, view.height/2)

    fun draw(canvas: Canvas) {
        TestPaint.color = Color.BLACK
        canvas.drawRect(r1, TestPaint)
    }
}