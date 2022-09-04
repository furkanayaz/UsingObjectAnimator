package com.furkanayaz.usingobjectanimator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.furkanayaz.usingobjectanimator.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onTouchListeners()
        onClickListeners()

    }

    @SuppressLint("ClickableViewAccessibility")
    fun onTouchListeners() {
        binding.cvMain.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, motionEvent: MotionEvent): Boolean {
                if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                    startAnimation()
                }else if (motionEvent.action == MotionEvent.ACTION_UP || motionEvent.action == MotionEvent.ACTION_CANCEL) {
                    endAnimation()
                }

                return false

            }

        })
    }

    fun onClickListeners() {
        binding.cvMain.setOnClickListener {
            Log.e("RUNNING", "CLICKED")
        }
    }

    @SuppressLint("Recycle")
    fun startAnimation() {
        binding.cvMain.setCardBackgroundColor(getColor(R.color.second_color))

        val scaleX = ObjectAnimator.ofFloat(binding.cvMain, "scaleX", 1.0f, 0.95f)
        val scaleY = ObjectAnimator.ofFloat(binding.cvMain, "scaleY", 1.0f, 0.95f)

        val animatorSet = AnimatorSet()
        animatorSet.duration = 250
        animatorSet.play(scaleX).with(scaleY)
        animatorSet.start()
    }

    fun endAnimation() {
        binding.cvMain.setCardBackgroundColor(getColor(R.color.first_color))

        val scaleX = ObjectAnimator.ofFloat(binding.cvMain, "scaleX", 0.95f, 1.0f)
        val scaleY = ObjectAnimator.ofFloat(binding.cvMain, "scaleY", 0.95f, 1.0f)

        val animatorSet = AnimatorSet()
        animatorSet.duration = 250
        animatorSet.play(scaleX).with(scaleY)
        animatorSet.start()
    }

}