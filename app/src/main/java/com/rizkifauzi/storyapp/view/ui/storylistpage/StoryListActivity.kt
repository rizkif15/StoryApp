package com.rizkifauzi.storyapp.view.ui.storylistpage

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import androidx.activity.viewModels
import com.rizkifauzi.storyapp.R
import com.rizkifauzi.storyapp.databinding.ActivityStoryListBinding
import com.rizkifauzi.storyapp.view.ViewModelFactory
import com.rizkifauzi.storyapp.view.ui.splash.SplashActivity

class StoryListActivity : AppCompatActivity() {

    private val viewModel by viewModels<StoryListViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityStoryListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getSession().observe(this) { user ->
            if (!user.isLogin) {
                startActivity(Intent(this, SplashActivity::class.java))
                finish()
            }
        }

        setupView()
        setupAction()

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
        binding.topBar.setOnMenuItemClickListener{ menuItem ->
            when (menuItem.itemId){
                R.id.btnLogout -> {
                    viewModel.logout()
                    true
                }
                else -> false
            }
        }
    }
}