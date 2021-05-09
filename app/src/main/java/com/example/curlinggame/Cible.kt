package com.example.curlinggame

import android.graphics.*
import java.util.*

open class Cible (var hauteur1 : Float, var largeur1: Float ,var rayonC : Float,var interval : Float, val  view: CurlingView) {
    val cible1Paint = Paint()
    val cible2Paint = Paint()

    fun draw(canvas: Canvas) {
        for (i in 0..10) {
            val r1 = RectF(largeur1 + (2 * i * interval), hauteur1, largeur1 + rayonC + (2 * i * interval), hauteur1 + rayonC)
            val r2 = RectF(largeur1 + (2 * i * interval), hauteur1 + 2 * interval, largeur1 + rayonC + (2 * i * interval),hauteur1 + 2 * interval + rayonC)
            if (i  % 2 == 0) {
                cible1Paint.color = Color.YELLOW
                cible2Paint.color = Color.WHITE
            } else if (i % 3 ==0) {
                cible1Paint.color = Color.RED
                cible2Paint.color = Color.CYAN
            } else if (i % 5 ==0) {
                cible1Paint.color = Color.BLACK
                cible2Paint.color = Color.DKGRAY
            }
            else{
                cible1Paint.color = Color.MAGENTA
                cible2Paint.color = Color.GRAY
            }
            canvas.drawRect(r1, cible1Paint)
            canvas.drawRect(r2,cible2Paint)
        }
    }
}

