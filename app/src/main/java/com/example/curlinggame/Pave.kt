package com.example.curlinggame

import android.graphics.*
import java.util.*

class Pave (var rayonP : Float, var hauteur : Float, var largeur : Float, val view : CurlingView) {
    val pavePaint = Paint()
    var playerB = PointF()
    val r = RectF(largeur - rayonP, hauteur, largeur + rayonP, view.height)
    var paveVitesse = 0f
    var paveVitesseX = 0f
    var paveVitesseY = 0f
    var OnScreen = true
    var paveRadius = 0f


    fun draw(canvas: Canvas?) {
        pavePaint.color = Color.RED
        canvas?.drawOval(r, pavePaint)
    }

    fun setRect() {
        r.set(largeur - rayonP, hauteur, largeur + rayonP, view.height)
    }

    fun launch(angle: Double) {
        playerB.x = paveRadius
        playerB.y = view.width / 2f
        paveVitesseX = (paveVitesse * Math.sin(angle)).toFloat()
        paveVitesseY = (-paveVitesse * Math.cos(angle)).toFloat()
        OnScreen = true
    }

    fun update(interval: Double) {
        var up = (interval * paveVitesse).toFloat()
        if (OnScreen) {
            playerB.x += (interval * paveVitesseX).toFloat()
            playerB.y += (interval * paveVitesseY).toFloat()
            r.offset(0f, up)
        }
    }
}