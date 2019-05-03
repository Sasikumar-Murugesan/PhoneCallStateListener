package com.sasi.calllistenerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
    }

    public fun printStatus(callEnded:Boolean)
    {
        Toast.makeText(this@MainActivity, "OnGoingCall: ${callEnded}", Toast.LENGTH_SHORT).show()
    }
}
