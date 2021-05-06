package com.example.curlinggame

import android.graphics.*
import java.util.*

class Pave (var x1 : Float, var y1 : Float, var rayonP : Float, val view : CurlingView) {
    val random = Random()
    val pavePaint = Paint()
    val r = RectF(x1, y1, x1 + (2 * rayonP), y1 - (2 * rayonP))
    val color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    var t1 = Obstacle.Obstaclec().r1
    var t2 = Obstacle.Obstacler().r2
    var t3 = Obstacle.Obstacleg().r3
    fun draw(canvas: Canvas?) {
        pavePaint.color = color
        canvas?.drawOval(r, pavePaint)
    }

    fun OnScreen() : Boolean {
        return(x1 + rayonP < view.width || x1 - rayonP  > 0 || y1 + rayonP < view.height   || y1 - rayonP > 0 )
    }
    fun ToucheObstacle () : Boolean {
        return(r.intersect(t1) || r.intersect(t2) || r.intersect(t3) )
    }
}
