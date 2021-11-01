package com.example.songapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.songapp.databinding.ActivityMainBinding
import com.example.songapp.databinding.ActivityVideoBinding
import com.example.songapp.databinding.ActivityWebBinding

class VideoActivity : AppCompatActivity() {
    lateinit var binding: ActivityVideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        binding = ActivityVideoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val mediaController=MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setMediaController(mediaController)
        binding.videoView.setVideoURI(Uri.parse("android.resource://$packageName/${R.raw.izz}"))
        binding.videoView.requestFocus()

        binding.videoView.start()
    }
}
