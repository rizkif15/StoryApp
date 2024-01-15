package com.rizkifauzi.storyapp.view.ui.splash

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import com.rizkifauzi.storyapp.R
import com.rizkifauzi.storyapp.databinding.ActivitySplashBinding
import com.rizkifauzi.storyapp.view.ui.login.LoginActivity
import com.rizkifauzi.storyapp.view.ui.register.RegisterActivity
import android.view.animation.AccelerateDecelerateInterpolator

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
        playAnimation()

    }

    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -10f, 10f).apply {
            duration = 1000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        Handler().postDelayed({
            ObjectAnimator.ofFloat(binding.textView6, View.ALPHA, 0f, 1f).apply {
                duration = 1000
            }.start()

            Handler().postDelayed({
                ObjectAnimator.ofFloat(binding.textView7, View.ALPHA, 0f, 1f).apply {
                    duration = 1000
                }.start()

                Handler().postDelayed({
                    ObjectAnimator.ofFloat(binding.btnDaftar, View.ALPHA, 0f, 1f).apply {
                        duration = 1000
                    }.start()

                    Handler().postDelayed({
                        ObjectAnimator.ofFloat(binding.btnLogin, View.ALPHA, 0f, 1f).apply {
                            duration = 1000
                        }.start()
                    }, 200)
                }, 200)
            }, 200)
        }, 200)
    }



    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.btnDaftar.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}