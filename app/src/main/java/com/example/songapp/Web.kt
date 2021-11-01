package com.example.songapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import com.example.songapp.databinding.ActivityMainBinding
import com.example.songapp.databinding.ActivityWebBinding

class Web : AppCompatActivity() {
    lateinit var binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.web.webViewClient= WebViewClient()
        binding.web.loadUrl("https://www.youtube.com/")
        binding.web.settings.javaScriptEnabled =true
        binding.web.settings.builtInZoomControls =true

    }

    override fun onBackPressed() {
        if (binding.web.canGoBack())
            binding.web.goBack()
        else
        super.onBackPressed()
    }
}