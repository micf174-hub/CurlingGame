package com.example.curlinggame
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView

class CurlingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val FD = Paint()
    var width = 0f
    var height = 0f
    var drawing = false
    lateinit var thread : Thread
    val player = Player(0f, 0f, 0f,0f,this)
    val cible = Cible(0f, 0f,0f,0f,this)
    val obstacle1 = ObstacleC(0f, this,cible)
    val obstacle2 = ObstacleR(0f,0f,this,cible)
    val obstacle3 = ObstacleT(0f,this,cible)
    val pave = Pave( this,cible, obstacle1, obstacle2, obstacle3)
    var NB_S = 0

    init    {
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
        var previousFrameTime = System.currentTimeMillis()
        while (drawing) {
            val currentTime = System.currentTimeMillis()
            val elapsedTimeMS = (currentTime-previousFrameTime).toDouble()
            updatePositions(elapsedTimeMS)
            draw()
            previousFrameTime = currentTime
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w.toFloat()
        height = h.toFloat()

        player.hauteur1 = (9 *h/10f)
        player.hauteur2 = (8 *h/10f)
        player.largeur = (w/2f)
        player.epaisseur = (w/30f)
        player.setRect()
        player.setr1(9*h/10f)

        obstacle1.rayon1 = (w/20f)
        obstacle1.setRect()

        obstacle2.rayon2 = (w/20f)
        obstacle2.vO1Init = (w/2f)
        obstacle2.setRect()

        obstacle3.rayon3 = (w/20f)
        obstacle3.setRect()

        cible.rayonC = (w/15f)
        cible.intervalC = (w/20f)
        cible.largeur1 = (w/35f)
        cible.hauteur1 = (w/20f)


        pave.paveVitesse = (3f *h)
        pave.paveR = (w/50f)
        pave.launch(0.0)

    }
    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(),
                    canvas.height.toFloat(), FD)
            player.draw(canvas)
            if(pave.OnScreen)
            obstacle1.draw(canvas)
            obstacle2.draw(canvas)
            obstacle3.draw(canvas)
            cible.draw(canvas)
            pave.draw(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }

    fun updatePositions(elapsedTimeMS: Double) {
        val interval = elapsedTimeMS / 5000.0
        pave.update(interval)
        obstacle2.update(interval)

    }

    override fun onTouchEvent(e: MotionEvent): Boolean {
        val action = e.action
        if (action == MotionEvent.ACTION_DOWN
                || action == MotionEvent.ACTION_MOVE) {
            tir(e)
        }
        return true
    }

    fun tir(event: MotionEvent) {
        if (!pave.OnScreen) {
            val angle = alignT(event)
            pave.launch(angle)
            ++NB_S
        }
    }

    fun alignT(event: MotionEvent): Double {
        val touchPoint = Point(event.x.toInt(), event.y.toInt())
        val centerMinusX = width/2 + touchPoint.x
        var angle = 0.0
        if (centerMinusX != 0.0f )
            angle = Math.atan(centerMinusX / (touchPoint.y).toDouble())
        if (touchPoint.x < width / 2)
            angle += Math.PI/2
        player.alignement(angle)
        return angle
    }



    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

        }

        override fun surfaceCreated(holder: SurfaceHolder) {

        }

        override fun surfaceDestroyed(holder: SurfaceHolder) {
        }
    }