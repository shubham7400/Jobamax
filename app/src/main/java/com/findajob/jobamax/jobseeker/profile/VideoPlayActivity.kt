package com.findajob.jobamax.jobseeker.profile

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.findajob.jobamax.databinding.ActivityVideoPlayBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
 import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.util.Util

class VideoPlayActivity : AppCompatActivity() {
    lateinit var binding: ActivityVideoPlayBinding

    private val playbackStateListener: Player.Listener  = playbackStateListener()

    private var player: ExoPlayer? = null

    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L

    var videoUrl = ""

    private var currentVideoUrl: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVideoPlayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        videoUrl = intent.getStringExtra("video_url") ?: ""

        configureUi()
    }

    private fun configureUi() {
        currentVideoUrl = videoUrl
        initializePlayer()
    }
    private fun initializePlayer() {
        val trackSelector = DefaultTrackSelector(this).apply {
            setParameters(buildUponParameters().setMaxVideoSizeSd())
        }
        if (player == null){
            try {
                player = ExoPlayer.Builder(this)
                    .setTrackSelector(trackSelector)
                    .build()
                    .also { exoPlayer ->
                        binding.videoView.player = exoPlayer
                    }.also { exoPlayer ->
                        currentVideoUrl?.let {
                            val mediaItem = MediaItem.fromUri(videoUrl)
                            exoPlayer.setMediaItem(mediaItem)
                            exoPlayer.playWhenReady = playWhenReady
                            exoPlayer.seekTo(currentWindow, playbackPosition)
                            exoPlayer.addListener(playbackStateListener)
                            exoPlayer.prepare()
                        }
                    }
            }catch (e: Exception){}
         }
    }

    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.currentWindowIndex
            playWhenReady = this.playWhenReady
            removeListener(playbackStateListener)
            release()
        }

        player = null
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        binding.videoView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        releasePlayer()
        finish()
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        if ((Util.SDK_INT < 24 || player == null)) {
            initializePlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }
}

private fun playbackStateListener() = object : Player.Listener {
    override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
        val stateString: String = when (playbackState) {
            ExoPlayer.STATE_IDLE -> "ExoPlayer.STATE_IDLE      -"
            ExoPlayer.STATE_BUFFERING -> "ExoPlayer.STATE_BUFFERING -"
            ExoPlayer.STATE_READY -> "ExoPlayer.STATE_READY     -"
            ExoPlayer.STATE_ENDED -> "ExoPlayer.STATE_ENDED     -"
            else -> "UNKNOWN_STATE             -"
        }
        Log.d(TAG, "changed state to $stateString")
    }
}

private const val TAG = "VideoPlayActivity"