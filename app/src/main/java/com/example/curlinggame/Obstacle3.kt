package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleT(val view : CurlingView) : Obstacle(view.width/10f,view.width/10f) {
    var r3 = RectF(
            3*view.width / 4 - rayonO,
            view.height / 2 - rayonO,
            3* view.width / 4 + rayonO,
            view.height / 2 + rayonO
    )
    override fun draw(canvas: Canvas?) {
        val obstaclePaint = Paint()
        obstaclePaint.color = Color.GRAY
        canvas?.drawRect(r3, obstaclePaint)
    }
    override fun update(interval: Double){
        var vO1 = vitesseO
        var up = (interval * vO1).toFloat()
        r3.offset(up, 0f)
        if (r3.left < r.left -30f || r3.right > r3.right + 30f) {
            vO1 *= -1
            up = (interval * vO1).toFloat()
            r3.offset(up, 0f)
        }
    }

    override fun setRect() {

        r3.set(
            3 * view.width / 4 - rayonO,
            view.height / 2 - rayonO,
            3 * view.width / 4 + rayonO,
            view.height / 2 + rayonO
        )
    }


}