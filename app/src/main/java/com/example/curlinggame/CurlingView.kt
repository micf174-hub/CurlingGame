package com.example.curlinggame
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Build
import android.util.AttributeSet
import android.util.SparseIntArray
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.annotation.RequiresApi
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class CurlingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr), SurfaceHolder.Callback, Runnable {
    lateinit var canvas: Canvas
    val FD = Paint()
    var width = 0f
    var height = 0f
    var drawing = false
    lateinit var thread : Thread
    val player = Player(0f, 0f, 0f,this)
    val obstacle1 = ObstacleC(0f, this)
    val obstacle2 = ObstacleR(0f,this)
    val obstacle3 = ObstacleT(0f,this)
    val cible = Cible(0f, this)
    val pave = Pave( 0f,0f,0f,this)
    var shotsFired = 0
    val soundPool: SoundPool
    val soundMap: SparseIntArray

    init    {
        FD.color = Color.GREEN

        val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()

        soundPool = SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build()
        soundMap = SparseIntArray(3)
        soundMap.put(0, soundPool.load(context, R.raw.BEEP_Bip_de_caisse, 1))
    }

    open fun playObstacleSound() {
        soundPool.play(soundMap.get(0), 1f, 1f, 1, 0, 1f)
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

        obstacle1.rayon1 = (w/40f)
        obstacle1.setRect()

        obstacle2.rayon2 = (w/40f)
        obstacle2.setRect()

        obstacle3.rayon3 = (w/40f)
        obstacle3.setRect()

        cible.rayonC = (w/10f)
        cible.setRect()

        pave.rayonP = (w/30f)
        pave.hauteur = (95 *h/100f)
        pave.largeur = (w/2f)
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
    override fun onTouchEvent(e: MotionEvent): Boolean {
        val action = e.action
        if (action == MotionEvent.ACTION_DOWN
                || action == MotionEvent.ACTION_MOVE) {
            fireCanon(e)
        }
        return true
    }
    fun fireCanon(event: MotionEvent) {
        if (! pave.OnScreen()) {
            val angle = alignCanon(event)
            pave.launch(angle)
            ++shotsFired
        }
    }
    fun alignCanon(event: MotionEvent): Double {
        val touchPoint = Point(event.x.toInt(), event.y.toInt())
        val centerMinusY = height / 2 - touchPoint.y
        var angle = 0.0
        if (centerMinusY != 0.0f)
            angle = Math.atan((touchPoint.x).toDouble()/ centerMinusY)
        if (touchPoint.y > height / 2)
            angle += Math.PI
        player.align(angle)
        return angle
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

        }

        override fun surfaceCreated(holder: SurfaceHolder) {

        }

        override fun surfaceDestroyed(holder: SurfaceHolder) {
        }
    }