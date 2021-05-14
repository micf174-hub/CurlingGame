package com.example.curlinggame

import android.graphics.*
import android.os.Build
import androidx.annotation.RequiresApi

class Pave (val view : CurlingView, val cible : Cible, val obstacle : Obstacle) {
    val pavePaint = Paint()
    var paveB = PointF()
    var paveVitesse = 0f
    var paveVitesseX = 0f
    var paveVitesseY = 0f
    var OnScreen = true
    var paveR = 0f



    fun launch(angle: Double) {
        paveB.x = view.width / 2f
        paveB.y = view.height - 2 * paveR
        paveVitesseX = (paveVitesse * Math.cos(angle)).toFloat()
        paveVitesseY = (paveVitesse * Math.cos(angle)).toFloat()
        OnScreen = true
    }

    fun draw(canvas: Canvas?) {
        pavePaint.color = Color.RED
        canvas?.drawCircle(paveB.x,paveB.y,paveR, pavePaint)
    }

    fun resetPave(){
        paveVitesse = 0f
        paveVitesseX = 0f
        paveVitesseY = 0f
        paveB.x = view.width /2f
        paveB.y = paveR
    }

    fun update(interval: Double) {
        if (OnScreen) {
            paveB.x += (interval * paveVitesseX).toFloat()
            paveB.y += (interval * paveVitesseY).toFloat()

            if(paveB.x + paveR > view.width || paveB.x - paveR < 0){
                paveVitesseX *= - 1
                paveB.offset((paveVitesseX * interval).toFloat(),0f)
            }

            else if(paveB.y+ paveR < obstacle.r.top && paveB.x - paveR < obstacle.r.right && paveB.x + paveR >  obstacle.r.left) {
                paveVitesseY *= - 1
            }
            else if(paveB.y+ paveR < obstacle.r.top  && paveB.x - paveR < obstacle.r.right && paveB.x + paveR >  obstacle.r.left){
                obstacle.DetecO()
            }

            else if(paveB.y+ paveR < obstacle.r.top && paveB.x - paveR < obstacle.r.right && paveB.x +paveR >  obstacle.r.left){
                obstacle.DetecO()
            }

            else if(paveB.y+ paveR < cible.r2.top && paveB.x - paveR < cible.r2.right && paveB.x + paveR >  cible.r2.left){
                cible.score()
            }
            else if(paveB.y + paveR > view.height || paveB.y + paveR < 0) {
                OnScreen = false
            }
        }
    }
}