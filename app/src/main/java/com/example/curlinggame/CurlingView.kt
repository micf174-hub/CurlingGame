package com.example.projetba2info
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.*

class CurlingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable{

    val background = Paint()
    val random = Random()
    val b1 = Pave(random.nextFloat()*500, random.nextFloat()*1000,
        random.nextFloat()*500)
    val b2 = Pave(random.nextFloat()*500, random.nextFloat()*1000,
        random.nextFloat()*500)
    val b3 = Pave(random.nextFloat()*500, random.nextFloat()*1000,
        random.nextFloat()*500)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background.color = Color.WHITE
        canvas?.drawRect(0F, 0F, width.toFloat(), height.toFloat(),
            background)
        b1.draw(canvas)
        b2.draw(canvas)
        b3.draw(canvas)
    }
}
