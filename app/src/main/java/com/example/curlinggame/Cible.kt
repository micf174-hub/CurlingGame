package com.example.curlinggame

import android.graphics.*
import java.util.*

class Cible (var hauteur1 : Float, var largeur1: Float, var hauteur2: Float, var largeur2: Float ,var rayonC : Float,var interval : Float, val  view: CurlingView) {
    val random = Random()
    val ciblePaint = Paint()
    val textPaint = Paint()
    var NB_C = 0

    init{
        for(i in 0..5){
            var r1 = RectF(view.width/20 + (i * interval),view.height/20,view.width/20 + rayonC + (i * interval),view.height/20 + rayonC)
        }
        for(i in 0..5){
            var r2 = RectF(view.width/20 + (i * interval),view.height/15,view.width/20 + rayonC + (i * interval),view.height/15 + rayonC)
        }
    }

    fun rand(from: Int, to: Int): Int {
        return random.nextInt(to - from) + from
    }
    fun draw(canvas: Canvas) {
        val NB_R = rand(0, 3)
        for(i in 0..10) {
            if (NB_R == 0) {
                ciblePaint.color = Color.YELLOW
            }
            else if (NB_R == 1) {
                ciblePaint.color = Color.RED
            }
            else if (NB_R == 2) {
                ciblePaint.color = Color.BLUE
            }

            canvas.drawRect(r1, ciblePaint)
        }
    }

    fun setRect() {
        r1.set(rand1 - rayonC,rand2-rayonC, rand1 + rayonC, rand2 + rayonC)
    }
}