package com.zeph7.dinnerdecider

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hiding title bar of this activity
        window.requestFeature(Window.FEATURE_NO_TITLE)

        //making this activity fullscreen
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)

        //make the layout contents show
        setContentView(R.layout.activity_splash)

        //4 second splash time
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        },4000)
    }
}
