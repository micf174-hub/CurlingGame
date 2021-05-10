package com.example.curlinggame

import android.graphics.*

class Pave (val view : CurlingView) {
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
        paveVitesseY = (- paveVitesse * Math.cos(angle)).toFloat()
        OnScreen = true
    }

    fun draw(canvas: Canvas?) {
        pavePaint.color = Color.RED
        canvas?.drawCircle(paveB.x,paveB.y,paveR, pavePaint)
    }

    fun update(interval: Double) {
        var up = (interval * paveVitesse).toFloat()
        if (OnScreen) {
            paveB.x += (interval * paveVitesseX).toFloat()
            paveB.y += (interval * paveVitesseY).toFloat()

        }
    }
}