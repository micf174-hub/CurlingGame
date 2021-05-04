package com.example.curlinggame
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.SurfaceHolder
import android.view.SurfaceView
import java.util.*

class CurlingView @JvmOverloads constructor (context: Context, attributes: AttributeSet? = null, defStyleAttr: Int = 0): SurfaceView(context, attributes,defStyleAttr){

    lateinit var canvas = Canvas

    val displayMetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displayMetrics)

    var width = displayMetrics.widthPixels
    var height = displayMetrics.heightPixels

    (Activity) getContext()).getWindowManager()
    .getDefaultDisplay()
    .getMetrics(displayMetrics);
    override fun onTouchEvent(){

    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int,
                                width: Int, height: Int) {}

    override fun surfaceCreated(holder: SurfaceHolder) {}

    override fun surfaceDestroyed(holder: SurfaceHolder) {}
}
