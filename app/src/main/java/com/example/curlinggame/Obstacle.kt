package com.example.curlinggame

import android.os.Build
import androidx.annotation.RequiresApi

open class Obstacle (var rayon: Float, val view: CurlingView) {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    open fun interaction() {
        view.playObstacleSound()
    }
}
