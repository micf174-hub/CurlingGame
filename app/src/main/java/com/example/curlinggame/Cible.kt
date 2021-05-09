package com.example.curlinggame

import android.graphics.*
import java.util.*

class Cible (var rayonC : Float, val  view: CurlingView) {
    val random = Random()
    val ciblePaint = Paint()
    val textPaint = Paint()
    var NB_C = 0
    var rand1 = random.nextFloat() * view.width
    var rand2 = random.nextFloat() * view.height
    var r4 = RectF(rand1 - rayonC,rand2-rayonC, rand1 + rayonC, rand2 + rayonC)


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
            var rand1 = random.nextFloat() * view.width
            var rand2 = random.nextFloat() * view.height
            var r4 = RectF(rand1 - rayonC,rand2-rayonC, rand1 + rayonC, rand2 + rayonC)
            canvas.drawRect(r4, ciblePaint)
        }
    }

    fun setRect() {
        r4.set(rand1 - rayonC,rand2-rayonC, rand1 + rayonC, rand2 + rayonC)
    }
}