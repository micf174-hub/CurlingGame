package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleT(var rayon3: Float, val view: CurlingView,var cible: Cible) {
    val obstacleTPaint = Paint()
    val r3 = RectF(
        3*view.width / 4 - rayon3,
        view.height / 2 - rayon3,
        3* view.width / 4 + rayon3,
        view.height / 2 + rayon3
    )

    fun draw(canvas: Canvas?) {
        obstacleTPaint.color = Color.GRAY
        canvas?.drawRect(r3, obstacleTPaint)
    }

    fun setRect() {
        r3.set(
            3 * view.width / 4 - rayon3,
            view.height / 2 - rayon3,
            3 * view.width / 4 + rayon3,
            view.height / 2 + rayon3
        )
    }

    fun ChocO3(pave : Pave){
        pave.resetPave()

    }

}