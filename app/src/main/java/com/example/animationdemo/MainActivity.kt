package com.example.animationdemo

import android.animation.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewPropertyAnimator
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun fadeView(view: View) {
        val fadeAnimator = AnimatorInflater.loadAnimator(this, R.animator.fade)
        fadeAnimator.apply {
            setTarget(iv_wheel)
            start()
        }
    }

    public fun rotateView(view: View) {
        val rotateAnimator = AnimatorInflater.loadAnimator(this, R.animator.rotate)
        rotateAnimator.apply {
            setTarget(iv_wheel)
            start()
        }
    }

    fun scaleView(view: View) {
        val scaleAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale)
        scaleAnimator.apply {
            setTarget(iv_wheel)
            start()
        }
    }

    fun translateView(view: View) {
        val translateAnimator = AnimatorInflater.loadAnimator(this, R.animator.translate)
        translateAnimator.apply {
            setTarget(iv_wheel)
            start()
        }
    }

    fun flipFromXML(view: View) {
        val animator = AnimatorInflater.loadAnimator(this, R.animator.set)
        animator.apply {
            setTarget(iv_wheel)
            start()
        }

    }

    fun flipFromCode(view: View) {
        val rootSet = AnimatorSet()
        val rotateAnimation = ObjectAnimator.ofFloat(iv_wheel, "rotationX", 0.0f, 360f)

        val childSet = AnimatorSet()
        val scaleXAnimation = ObjectAnimator.ofFloat(iv_wheel, "scaleX", 1.0f, 1.5f)
        val scaleYAnimation = ObjectAnimator.ofFloat(iv_wheel, "scaleY", 1.0f, 1.5f)

//        rootSet.playSequentially(rotateAnimation,childSet)
//        childSet.playTogether(scaleXAnimation,scaleYAnimation)

        rootSet.play(rotateAnimation).before(childSet)
        childSet.play(scaleXAnimation).with(scaleYAnimation)

        rootSet.start()
    }

    fun viewPropertyAnimator(view: View) {
        val animation: ViewPropertyAnimator = iv_wheel.animate()
        animation.apply {
            rotationX(360f)
            scaleX(1.5f)
            scaleY(1.5f)
            duration = 800
            interpolator = BounceInterpolator()
            start()
        }
    }

    fun valuePropertyHolder(view: View) {

        val rotationX = PropertyValuesHolder.ofFloat("rotationX", 180f)
        val scaleX = PropertyValuesHolder.ofFloat("scaleX", 2.0f)
        val scaleY=PropertyValuesHolder.ofFloat("scaleY",2.0f)

        val objAnimator=ObjectAnimator.ofPropertyValuesHolder(iv_wheel,rotationX,scaleX,scaleY)

        objAnimator.apply {
            duration=2000
            interpolator= OvershootInterpolator()
            repeatMode=ValueAnimator.REVERSE
            repeatCount=1
            start()
        }
    }
}