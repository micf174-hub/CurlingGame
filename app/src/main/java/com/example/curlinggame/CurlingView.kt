package com.example.curlinggame
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.random.Random

class CurlingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val FD = Paint()
    var width = 0f
    var height = 0f
    var drawing = false
    lateinit var thread : Thread
    val player = Player(0f, 0f, this)
    val obstacle1 = ObstacleC(0f, this)
    val obstacle2 = ObstacleR(0f,this)
    val obstacle3 = ObstacleT(0f,this)
    val cible = Cible(0f, this)
    val pave = Pave( 0f,0f,this)

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
        while (drawing) {
            draw()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        width = w.toFloat()
        height = h.toFloat()

        player.hauteur1 = (9 *h/10f)
        player.hauteur2= (8 *h/10f)
        player.setRect()

        obstacle1.rayon1 = (w/10f)
        obstacle1.setRect()

        obstacle2.rayon2 = (w/10f)
        obstacle2.setRect()

        obstacle3.rayon3 = (w/10f)
        obstacle3.setRect()

        cible.rayonC = (w/10f)
        cible.setRect()

        pave.rayonP = (w/10f)
        pave.setRect()
    }
    fun draw() {
        if (holder.surface.isValid) {
            canvas = holder.lockCanvas()
            canvas.drawRect(0f, 0f, canvas.width.toFloat(),
                    canvas.height.toFloat(), FD)
            player.draw(canvas)
            obstacle1.draw(canvas)
            obstacle2.draw(canvas)
            obstacle3.draw(canvas)
            cible.draw(canvas)
            pave.draw(canvas)
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