package com.example.curlinggame

import android.graphics.*
import java.util.*

class Pave (var rayonP : Float, var hauteur : Float, var largeur : Float, val view : CurlingView) {
    val random = Random()
    val pavePaint = Paint()
    val r = RectF(largeur-rayonP, hauteur, largeur + rayonP,view.height)
    var canonpaveVitesseX = 0f
    var canonpaveVitesseY = 0f
    var canonpaveOnScreen = true
    var canonpaveVitesse = 0f
    var dx: Int
    var dy: Int
    var t1 = ObstacleC().r1
    var t2 = ObstacleR().r2
    var t3 = ObstacleT().r3

    init {
        if (random.nextDouble() > 0.5) dx = 1 else dx = -1
        if (random.nextDouble() < 0.5) dy = 1 else dy = -1
    }

    fun draw(canvas: Canvas?) {
        pavePaint.color = Color.RED
        canvas?.drawOval(r, pavePaint)
    }
    open fun launch(angle: Double) {
        canonpaveVitesseX=(canonpaveVitesse*Math.sin(angle)).toFloat()
        canonpaveVitesseY=(-canonpaveVitesse*Math.cos(angle)).toFloat()
        canonpaveOnScreen = true
    }

    fun setRect() {
        r.set(view.width/2-rayonP, hauteur, view.width/2 + rayonP,view.height)
    }

    fun OnScreen() : Boolean {
        return(largeur + rayonP < view.width || largeur-rayonP >= 0 || hauteur + rayonP < view.height || hauteur >= 0)
    }

    fun ToucheObstacle () : Boolean {
        return(r.intersect(t1) || r.intersect(t2) || r.intersect(t3) )
    }
    fun Apparait () {

    }
    fun Disparait () {

    }
}