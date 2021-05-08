package com.example.curlinggame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity: AppCompatActivity() {

    lateinit var curlingView: CurlingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        curlingView = findViewById<CurlingView>(R.id.OUI)
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