package com.example.deeplinkinguitesting

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleIntent()
    }

    // adb shell am start -W -a android.intent.action.VIEW -d "myapp://example.com?screen=activitytwo" com.example.deeplinkinguitesting
    // adb shell am start -W -a android.intent.action.VIEW -d "http://www.example.com/myapp?screen=activitytwo" com.example.deeplinkinguitesting
    private fun handleIntent() {
        val data = intent.data
        if (data == null) return

        val screen = data.getQueryParameter("screen")

        if (screen == "activitytwo") {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

}
