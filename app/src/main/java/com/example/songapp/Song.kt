package com.example.songapp

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.SeekBar
import com.example.songapp.databinding.ActivityMainBinding
import com.example.songapp.databinding.ActivitySongBinding

class Song : AppCompatActivity(), View.OnClickListener,SeekBar.OnSeekBarChangeListener {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var binding: ActivitySongBinding

    var handler =Handler()
    lateinit var runnable: Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mediaPlayer = MediaPlayer.create(this, R.raw.fady)
        binding.play.setOnClickListener(this)
        binding.replay.setOnClickListener(this)

        binding.seekBar.setOnSeekBarChangeListener(this)
        binding.seekBar.max =mediaPlayer.duration
        binding.seekBar.progress =0

        runnable = Runnable {
            binding.seekBar.progress=mediaPlayer.currentPosition
            binding.time.text=(mediaPlayer.currentPosition/60000).toString()+":"+((mediaPlayer.currentPosition/1000)%60).toString()
            handler.postDelayed(runnable,1000)

        }
        handler.postDelayed(runnable,1000)
    mediaPlayer.setOnCompletionListener {
    mediaPlayer.pause()
    binding.play.setBackgroundResource(R.drawable.play)

}

    }

    override fun onClick(v: View?) {
        if (v!!.id == binding.play.id) {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
                binding.play.setBackgroundResource(R.drawable.pause)
            } else {
                mediaPlayer.pause()
                binding.play.setBackgroundResource(R.drawable.play)

            }
        }
        if (v!!.id == binding.replay.id){

            mediaPlayer.seekTo(0)

        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        mediaPlayer.stop()
        mediaPlayer.release()
        handler.removeCallbacks(runnable)
        finish()
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
      if (fromUser){
        if (seekBar != null) {
           mediaPlayer.seekTo(progress)

        }
      }
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {

    }

}

