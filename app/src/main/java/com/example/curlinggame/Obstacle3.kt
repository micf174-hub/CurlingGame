package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleT(val view : CurlingView) : Obstacle(view.width/10f,view.width/10f) {

    override fun draw(canvas: Canvas?) {
        val obstaclePaint = Paint()
        var r = RectF(
                3*view.width / 4 - rayonO,
                view.height / 2 - rayonO,
                3* view.width / 4 + rayonO,
                view.height / 2 + rayonO
        )
        obstaclePaint.color = Color.GRAY
        canvas?.drawRect(r, obstaclePaint)
    }
    override fun update(interval: Double){
        var vO1 = vitesseO
        var up = (interval * vO1).toFloat()
        r.offset(up, 0f)
        if (r.left < r.left -30f || r.right > r.right + 30f) {
            vO1 *= -1
            up = (interval * vO1).toFloat()
            r.offset(up, 0f)
        }
    }

    override fun setRect() {

        r.set(
            3 * view.width / 4 - rayonO,
            view.height / 2 - rayonO,
            3 * view.width / 4 + rayonO,
            view.height / 2 + rayonO
        )
    }

    override fun DetecO() {
        view.viesRestantes -= 1
    }
}