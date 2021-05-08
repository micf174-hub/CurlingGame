package com.example.curlinggame

import android.graphics.*
import java.util.*

open class Pave (var x1 : Float, var y1 : Float, var rayonP : Float, val view : CurlingView) {
    val random = Random()
    val pavePaint = Paint()
    val r = RectF(x1, y1, x1 + (2 * rayonP), y1 - (2 * rayonP))
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    var t1 = Obstacle.Obstaclec().r1
    var t2 = Obstacle.Obstacler().r2
    var t3 = Obstacle.Obstacleg().r3
    var dx: Int
    var dy: Int
    var canonpaveVitesseX = 0f
    var canonpaveVitesseY = 0f
    var canonpaveOnScreen = true
    var canonpaveVitesse = 0f

    init {
        if (random.nextDouble() > 0.5) dx = 1 else dx = -1
        if (random.nextDouble() < 0.5) dy = 1 else dy = -1
    }

    fun launch(angle: Double) {
        canonpaveVitesseX=(canonpaveVitesse*Math.sin(angle)).toFloat()
        canonpaveVitesseY=(-canonpaveVitesse*Math.cos(angle)).toFloat()
        canonpaveOnScreen = true
    }

    fun draw(canvas: Canvas?) {
        pavePaint.color = color
        canvas?.drawOval(r, pavePaint)
    }

    fun Bouge(canvas: Canvas?) {
        r.offset(5.0F * dx, 5.0F * dy)
        draw(canvas)
    }

    fun OnScreen() : Boolean {
        return(x1 + rayonP < view.width || x1 - rayonP  > 0 || y1 + rayonP < view.height   || y1 - rayonP > 0 )
    }
    fun ToucheObstacle () : Boolean {
        return(r.intersect(t1) || r.intersect(t2) || r.intersect(t3) )
    }
    fun Apparait () {

    }
    fun Disparait () {

    }

    fun Rebondit () {

    }
}
