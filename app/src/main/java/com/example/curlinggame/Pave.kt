package com.example.curlinggame

import android.graphics.*
import android.os.Build
import androidx.annotation.RequiresApi

class Pave (val view : CurlingView, val cible : Cible, val obstacle1: ObstacleC , val obstacle2 : ObstacleR, val obstacle3 : ObstacleT) {
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
        paveVitesseX = (paveVitesse * Math.sin(angle)).toFloat()
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

            else if(paveB.y+ paveR < obstacle2.r2.top && paveB.x + paveR < obstacle2.r2.right && paveB.x - paveR >  obstacle2.r2.left) {
                paveVitesseY *= - 1
                paveB.offset(paveVitesseY*interval.toFloat(),0f)
            }
            else if(paveB.y+ paveR < obstacle1.r1.top  && paveB.x + paveR < obstacle1.r1.right && paveB.x - paveR >  obstacle1.r1.left){
                view.paveCadeau()
            }

            else if(paveB.y+ paveR < obstacle3.r3.top && paveB.x + paveR < obstacle3.r3.right && paveB.x - paveR >  obstacle3.r3.left){
            }
            else if(paveB.y+ paveR < cible.r2.top && paveB.x + paveR < cible.r2.right && paveB.x - paveR >  cible.r2.left){
                view.score()
            }
            else if(paveB.y + paveR > view.height || paveB.y + paveR < 0) {
                OnScreen = false
            }
        }
    }
}