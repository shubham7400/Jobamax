package com.findajob.jobamax.dashboard.home.training.masterclass

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.MasterClassSessionGuestAdapter
import com.findajob.jobamax.dashboard.home.training.masterclass.adapter.VideoEpisodeAdapter
import com.findajob.jobamax.dashboard.home.training.masterclass.model.Topic
import com.findajob.jobamax.data.pojo.Category
import com.findajob.jobamax.databinding.ActivityMasterClassDetailsBinding
import com.findajob.jobamax.enums.FirebaseDynamicLinkPath
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.preference.getLoginType
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.preference.getUserType
import com.findajob.jobamax.util.log
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.util.Util
import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MasterClassDetailsActivity : BaseActivityMain<ActivityMasterClassDetailsBinding>(),
    MasterClassDetailsInterface, View.OnClickListener {
    var category: Category? = null
    var topic: Topic? = null
    var topicId: String? = null

    val viewModel: MasterClassViewModel by viewModels()
    val adapter: VideoEpisodeAdapter by lazy {
        VideoEpisodeAdapter()
    }
    private val guestAdapter: MasterClassSessionGuestAdapter by lazy {
        MasterClassSessionGuestAdapter()
    }


    private val playbackStateListener: Player.EventListener = playbackStateListener()

    private var player: SimpleExoPlayer? = null

    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L

    private var currentVedioUrl: String? = null

    override val layoutRes: Int get() = R.layout.activity_master_class_details

    override fun getViewModel(): ViewModel {
        return viewModel
    }

    override fun onCreated(instance: Bundle?) {
        binding.handler = this
        category = intent.getSerializableExtra("category_item") as Category
        topicId = intent.getStringExtra("topic_id")
        category?.let {
            initScreen()
        }
    }

    private fun initScreen() {
        setClickListeners()
        configureUi()
        fetchData()
        observeLiveData()
        initVideos()
    }

    private fun setClickListeners() {
        binding.tvPlayBtn.setOnClickListener(this)
        binding.ivAddMyList.setOnClickListener(this)
        binding.ivLikeDislike.setOnClickListener(this)
        binding.ivShare.setOnClickListener(this)
    }

    private fun configureUi() {

        adapter.clickListener = {
            binding.episode = it
            releasePlayer()
            currentVedioUrl = it.videoUrl
            initializePlayer()
        }

        guestAdapter.clickListener = {
            startActivity(Intent(this, MasterClassGuestDetailsActivity::class.java).putExtra("guest", it))
        }
        binding.rvEpisodes.adapter = adapter
        binding.rvGuest.adapter = guestAdapter

        if (binding.rvEpisodes.isVisible)
            binding.tvSession.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                com.findajob.jobamax.R.drawable.ic_arrow_down,
                0
            )
        else
            binding.tvSession.setCompoundDrawablesWithIntrinsicBounds(
                0,
                0,
                R.drawable.ic_arrow_up,
                0
            )

        binding.tvSession.setOnClickListener {
            if (binding.rvEpisodes.isVisible) {
                binding.tvSession.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_arrow_up,
                    0
                )
                binding.rvEpisodes.visibility = View.GONE
            } else {
                binding.tvSession.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_arrow_down,
                    0
                )
                binding.rvEpisodes.visibility = View.VISIBLE
            }
        }
    }

    private fun fetchData() {
        fetchVideoDetails()
        fetchVideoList()
    }

    private fun observeLiveData() {
        observeVideoDetails()
        observeVideoList()
    }

    private fun observeVideoList() {
        observe(viewModel.topic) { topic ->
            topic?.let {
                this.topic = it
                binding.item = topic
                when(topic.likeAction.toInt()){
                    1 -> {
                        binding.ivLikeDislike.setBackgroundResource( R.drawable.ic_thumb_up)
                    }
                    -1 -> {
                        binding.ivLikeDislike.setBackgroundResource( R.drawable.ic_thumb_down)
                    }
                    0 -> {
                        binding.ivLikeDislike.setBackgroundResource( R.drawable.ic_like)
                    }
                }
                currentVedioUrl = it.trailerUrl
                binding.tvVideoTitle.text = it.title
                binding.tvVideoDescription.text = it.description
                binding.tvSessionYear.text = it.seasonYear
                initializePlayer()
                guestAdapter.collection = topic.guests!!
                guestAdapter.notifyDataSetChanged()
                adapter.collection = topic.episodes!!
                adapter.notifyDataSetChanged()
            }
        }
    }


    private fun observeVideoDetails() {
        observe(viewModel.videoDetailsLD) {
            /*binding.item = it*/
        }
    }

    private fun fetchVideoDetails() {
        viewModel.fetchVideoDetails()
    }

    private fun fetchVideoList() {
        if (topicId != null){
            viewModel.fetchVideoList(topicId!!)
        }else{
            viewModel.fetchVideoList(category!!.topicId)
        }
    }

    private fun initVideos() {
        /*binding.apply {
            rvVideos.adapter = adapter
        }*/
    }

    override fun onBackPress() {
        onBackPressed()
    }


    private fun initializePlayer() {
        val trackSelector = DefaultTrackSelector(this).apply {
            setParameters(buildUponParameters().setMaxVideoSizeSd())
        }
        player = SimpleExoPlayer.Builder(this)
            .setTrackSelector(trackSelector)
            .build()
            .also { exoPlayer ->
                binding.videoView.player = exoPlayer
            }.also { exoPlayer ->
                currentVedioUrl?.let {
                    val mediaItem = MediaItem.fromUri(it)
                    exoPlayer.setMediaItem(mediaItem)
                    exoPlayer.playWhenReady = playWhenReady
                    exoPlayer.seekTo(currentWindow, playbackPosition)
                    exoPlayer.addListener(playbackStateListener)
                    exoPlayer.prepare()
                }
            }
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

    override fun onClick(view: View?) {
        when (view) {
            binding.tvPlayBtn -> {
                player?.let {
                    if (!it.isPlaying)
                        it.playWhenReady = true
                }
            }
            binding.ivAddMyList -> {
                viewModel.saveTopicInMyList(topic!!.topicId){
                    if (it)
                        binding.ivAddMyList.setImageResource(R.drawable.ic_done)
                    else
                        binding.ivAddMyList.setImageResource(R.drawable.ic_add)
                }
            }
            binding.ivLikeDislike -> {
                val likeDislikeDialogFragment = LikeDislikeDialogFragment.newInstance()
                likeDislikeDialogFragment.show(supportFragmentManager,"dialog")
                likeDislikeDialogFragment.clickListener = { likeAction ->
                    viewModel.saveTopicLikeAndDislike(topic!!.topicId, likeAction) { state ->
                        when (state) {
                            1 -> {
                                binding.ivLikeDislike.setBackgroundResource(R.drawable.ic_thumb_up)
                            }
                            -1 -> {
                                binding.ivLikeDislike.setBackgroundResource(R.drawable.ic_thumb_down)
                            }
                            0 -> {
                                binding.ivLikeDislike.setBackgroundResource(R.drawable.ic_like)
                            }
                        }
                    }
                }
            }
            binding.ivShare -> {
                val builder = Uri.Builder()
                builder.scheme("https")
                    .authority("jobamax.page.link")
                    .appendPath(FirebaseDynamicLinkPath.masterclassVideo.toString())
                    .appendQueryParameter("userType", getUserType().toString())
                    .appendQueryParameter("LoginType", getLoginType())
                    .appendQueryParameter("recruiterId", getUserId())
                    .appendQueryParameter("topicId", topic!!.topicId)
                val myUrl: String = builder.build().toString()
                val dynamicLink = Firebase.dynamicLinks.dynamicLink {
                    link = Uri.parse(myUrl)
                    domainUriPrefix = "https://jobamax.page.link"
                    androidParameters("com.findajob.jobamax") {
                    }
                }
                startActivity(Intent.createChooser(Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, dynamicLink.uri.toString())
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TITLE, "Jobamax master class video link")
                }, null))
            }
        }
    }
}

private const val TAG = "PlayerActivity"

private fun playbackStateListener() = object : Player.EventListener {
    override fun onPlaybackStateChanged(playbackState: Int) {
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

interface MasterClassDetailsInterface {
    fun onBackPress()
}