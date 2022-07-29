package com.batterb.filmslist.presentation.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.batterb.filmslist.databinding.ActivitySplashBinding
import com.batterb.filmslist.presentation.movies.MoviesActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            val intent = Intent(applicationContext, MoviesActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}