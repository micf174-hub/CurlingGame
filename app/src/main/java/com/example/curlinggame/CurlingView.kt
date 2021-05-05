package com.example.curlinggame
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView

class CurlingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val FD = Paint()
    var width = 0f
    var height = 0f
    var drawing = false
    lateinit var thread = Thread
    val player = Player(0f, 0f, this)
    val obstacle1 = Obstacle.Obstaclec(0f, 0f, 0f)
    val obstacle2 = Obstacle.Obstacler(0f, 0f, 0f)
    val cible = Cible(0f, 0f, 0f)
    val pave = Pave(0f, 0f, 0f)

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

        player.lsquareP = (w/24f)
        player.lsquareLP = (w/48f)

        pave.x1 = (w/2f)
        pave.y1 = (0f)
        pave.rayonP = (w/64f)

        obstacle1.x1 = (w/50f)
        obstacle1.y1 = (w/50f)
        obstacle1.rayonO1 = (w/100f)

        obstacle2.x1 = (w/50f)
        obstacle2.y1 = (w/50f)
        obstacle2.rayonO2 = (w/100f)

        cible.x1 = (w/100f)
        cible.y1 = (w/200f)
        cible.rayonC = (w/50f)
    }

    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(),
                    canvas.height.toFloat(), FD)
            player.draw(canvas)
            pave.draw(canvas)
            obstacle1.draw(canvas)
            obstacle2.draw(canvas)
            cible.draw(canvas)
            holder.unlockCanvasAndPost(canvas)
        }
    }



        override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

        }

        override fun surfaceCreated(holder: SurfaceHolder) {

        }

        override fun surfaceDestroyed(holder: SurfaceHolder) {
        }
    }