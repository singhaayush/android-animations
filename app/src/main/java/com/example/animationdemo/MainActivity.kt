package com.example.animationdemo

import android.animation.*
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var animationDrawable: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        iv_count.setBackgroundResource(R.drawable.drawable_animation)
        animationDrawable = iv_count.background as AnimationDrawable
        animationDrawable.start()
    }

    fun startStopAnimation(view: View) {
        if(animationDrawable.isRunning)
            animationDrawable.stop()
        else
            animationDrawable.start()
    }
}