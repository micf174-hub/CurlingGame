package com.example.curlinggame

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class ObstacleC( val view: CurlingView) : Obstacle(view.width/10f,view.width/10f) {


    override fun draw(canvas: Canvas?) {
        var obstaclePaint = Paint()
        r.left = view.width / 4 - rayonO
        r.top = view.height/2 - rayonO
        r.right = view.width / 4 + rayonO
        r.bottom = view.height / 2 + rayonO

        obstaclePaint.color = Color.BLUE
        canvas?.drawRect(r, obstaclePaint)
    }
    override fun setRect() {
        r.set(view.width / 4 - rayonO,
            view.height/2 - rayonO,
            view.width / 4 + rayonO,
            view.height / 2 + rayonO
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