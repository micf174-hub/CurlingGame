package com.example.curlinggame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.curlinggame.CurlingView
import com.example.curlinggame.R


class MainActivity: AppCompatActivity() {

    lateinit var curlingView: CurlingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        curlingView = findViewById<CurlingView>(R.id.vMain)
    }
    override fun onPause() {
        super.onPause()
        curlingView.pause()
    }

    override fun onResume() {
        super.onResume()
        curlingView.resume()
    }

}