package com.rizkifauzi.storyapp.view.ui.register

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.rizkifauzi.storyapp.R
import com.rizkifauzi.storyapp.databinding.ActivityRegisterBinding
import com.rizkifauzi.storyapp.view.component.ETEmail
import com.rizkifauzi.storyapp.view.component.ETNama
import com.rizkifauzi.storyapp.view.component.ETPass
import com.rizkifauzi.storyapp.view.component.MySubmitButton
import com.rizkifauzi.storyapp.view.ui.login.LoginActivity
import com.rizkifauzi.storyapp.view.ui.splash.SplashActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var myButton: MySubmitButton
    private lateinit var ETNama: ETNama
    private lateinit var ETEmail: ETEmail
    private lateinit var ETPass: ETPass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myButton = findViewById(R.id.submitDaftar)
        ETNama = findViewById(R.id.namaUser)
        ETEmail = findViewById(R.id.emailUser)
        ETPass = findViewById(R.id.passUser)
        setMyButtonEnable()

        ETNama.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

        ETEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

        ETPass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })

        myButton.setOnClickListener {

        }

        setupView()
        setupAction()
        playAnimation()
    }

    private fun setMyButtonEnable() {
        val result1 = ETNama.text
        val result2 = ETEmail.text
        val result3 = ETPass.text

        myButton.isEnabled =
            result1 != null && result1.toString().isNotEmpty()
                    && result2 != null && result2.toString().isNotEmpty()
                    && result3 != null && result3.toString().isNotEmpty()
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

        binding.submitDaftar.setOnClickListener {
            val email = binding.emailUser.text.toString()

            AlertDialog.Builder(this).apply {
                setTitle("Yeah!")
                setMessage("Akun dengan $email sudah jadi nih. Yuk, login dan belajar coding.")
                setPositiveButton("Lanjut") { _, _ ->
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
        val namaTextView =
            ObjectAnimator.ofFloat(binding.textView3, View.ALPHA, 1f).setDuration(200)
        val namaEditTextLayout =
            ObjectAnimator.ofFloat(binding.namaUser, View.ALPHA, 1f).setDuration(200)
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
        val login = ObjectAnimator.ofFloat(binding.submitDaftar, View.ALPHA, 1f).setDuration(200)

        AnimatorSet().apply {
            playSequentially(
                balik,
                title,
                message,
                namaTextView,
                namaEditTextLayout,
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