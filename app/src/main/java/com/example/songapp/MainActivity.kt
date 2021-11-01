package com.example.songapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.songapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var song: ImageButton
    lateinit var web: ImageButton
    lateinit var vedio: ImageButton
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.song.setOnClickListener(this)
        binding.vedio.setOnClickListener(this)
        binding.web.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v!!.id==binding.song.id){
            var intent =Intent(this, Song::class.java)
            startActivity(intent)

        }
        if (v!!.id==binding.web.id){

            var intent =Intent(this, Web::class.java)
            startActivity(intent)
        }
        if (v!!.id==binding.vedio.id){

            var intent =Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }
    }
}