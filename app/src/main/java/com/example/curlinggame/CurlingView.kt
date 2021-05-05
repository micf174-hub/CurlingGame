package com.example.curlinggame
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.*
class CurlingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable{

    lateinit var canvas : Canvas

    lateinit var thread = Thread

    var width = 0f
    var height = 0f
    var drawing = false
    val FD = Paint()
    val player = Player(0f ,0f , this)
    val obstacle1 = Obstacle.Obstaclec(0f,0f,0f)
    val obstacle2 = Obstacle.Obstacler(0f,0f,0f)
    val cible = Cible(0f,0f,0f)
    val pave = Pave(0f,0f,0f)

    init {
        FD.color = Color.GREEN
    }

    fun pause() {
        drawing = false
        thread.join()
    }

    fun resume() {
        drawing = true
        thread = Thread(this)
        thread.start()
    }

    override fun run() {
        while (drawing) {
            draw()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w.toFloat()
        height = h.toFloat()

        player.lsquareP = ()
        player.lsquareLP =()

        pave.x1 = ()
        pave.y1 = ()
        pave.rayonP = ()

        obstacle1.x1 = ()
        obstacle1.y1 = ()
        obstacle1.rayonO1 = ()

        obstacle2.x1 = ()
        obstacle2.y1 = ()
        obstacle2.rayonO2 = ()

        cible.x1 = ()
        cible.y1 = ()
        cible.rayonC = ()


    }

    override fun onTouchEvent(){

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

    }

    override fun surfaceCreated(holder: SurfaceHolder) {

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
    }
}

