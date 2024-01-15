package com.rizkifauzi.storyapp.view.ui.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.rizkifauzi.storyapp.R
import com.rizkifauzi.storyapp.data.pref.UserModel
import com.rizkifauzi.storyapp.databinding.ActivityLoginBinding
import com.rizkifauzi.storyapp.view.ViewModelFactory
import com.rizkifauzi.storyapp.view.ui.splash.SplashActivity
import com.rizkifauzi.storyapp.view.ui.storylistpage.StoryListActivity

class LoginActivity : AppCompatActivity() {

    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
        playAnimation()
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
        binding.back.setOnClickListener{
            startActivity(Intent(this, SplashActivity::class.java))
        }

        binding.submitLogin.setOnClickListener {
            val email = binding.emailUser.text.toString()
            viewModel.saveSession(UserModel(email, "sample_token"))
            AlertDialog.Builder(this).apply {
                setTitle("Yeah!")
                setMessage("Anda berhasil login. Sudah tidak sabar untuk belajar ya?")
                setPositiveButton("Lanjut") { _, _ ->
                    val intent = Intent(context, StoryListActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                    finish()
                }
                create()
                show()
            }
        }
    }

    private fun playAnimation() {
        val balik = ObjectAnimator.ofFloat(binding.back, View.ALPHA, 1f).setDuration(200)
        val title = ObjectAnimator.ofFloat(binding.textView, View.ALPHA, 1f).setDuration(200)
        val message =
            ObjectAnimator.ofFloat(binding.textView2, View.ALPHA, 1f).setDuration(200)
        val emailTextView =
            ObjectAnimator.ofFloat(binding.textView4, View.ALPHA, 1f).setDuration(200)
        val emailEditTextLayout =
            ObjectAnimator.ofFloat(binding.emailUser, View.ALPHA, 1f).setDuration(200)
        val passwordTextView =
            ObjectAnimator.ofFloat(binding.textView5, View.ALPHA, 1f).setDuration(200)
        val passwordEditTextLayout =
            ObjectAnimator.ofFloat(binding.passUser, View.ALPHA, 1f).setDuration(200)
        val tvnanya =
            ObjectAnimator.ofFloat(binding.tVnanya, View.ALPHA, 1f).setDuration(200)
        val tvbtnnanya =
            ObjectAnimator.ofFloat(binding.tVBtnNanya, View.ALPHA, 1f).setDuration(200)
        val login = ObjectAnimator.ofFloat(binding.submitLogin, View.ALPHA, 1f).setDuration(200)

        AnimatorSet().apply {
            playSequentially(
                balik,
                title,
                message,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                tvnanya,
                tvbtnnanya,
                login
            )
            startDelay = 200
        }.start()
    }

}