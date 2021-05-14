package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleC( val view: CurlingView) : Obstacle(view.width/10f,view.width/10f) {


    override fun draw(canvas: Canvas?) {
        var obstaclePaint = Paint()
        r.left = view.width / 4 - rayonO2
        r.top = view.height/2 - rayonO2
        r.right = view.width / 4 + rayonO2
        r.bottom = view.height / 2 + rayonO2

        obstaclePaint.color = Color.BLUE
        canvas?.drawRect(r, obstaclePaint)
    }
    override fun setRect() {
        r.set(view.width / 4 - rayonO2,
            view.height/2 - rayonO2,
            view.width / 4 + rayonO2,
            view.height / 2 + rayonO2
                )
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

    override fun DetecO(){
        view.viesRestantes+=1
    }
}