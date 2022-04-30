package com.example.cryptolize

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

@SuppressLint("CustomSplashScreen")
class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //splash screen
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        makeFullScreen()
        setContent {
            splashScreen.setKeepOnScreenCondition { false }
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }

    }

    private fun makeFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        actionBar?.hide()
    }
}