package com.arslan.nytimesnewsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var newsRepo: NewsRepo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val intent = Intent(Intent.ACTION_MAIN);
            intent.setClassName(this.packageName, "com.arslan.onboarding.splash.presentation.SplashActivity");
            startActivity(intent)
            finish()
        }
        GlobalScope.launch {
            newsRepo.invoke()
        }

    }
}

