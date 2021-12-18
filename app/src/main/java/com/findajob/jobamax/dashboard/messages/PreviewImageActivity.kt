package com.findajob.jobamax.dashboard.messages

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.databinding.ActivityPreviewImageBinding
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.krishna.fileloader.FileLoader
import com.krishna.fileloader.listener.FileRequestListener
import com.krishna.fileloader.pojo.FileResponse
import com.krishna.fileloader.request.FileLoadRequest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_play_video.*
import java.io.File

@AndroidEntryPoint
class PreviewImageActivity : BaseActivityMain<ActivityPreviewImageBinding>() {

    private lateinit var simpleExoPlayer: SimpleExoPlayer
    private lateinit var mediaDataSourceFactory: DataSource.Factory

    private lateinit var videoView: PlayerView
    private lateinit var videoPlayer: SimpleExoPlayer
    private lateinit var mediaItem: MediaItem

    private val viewModel: PreviewImageViewModel by viewModels()

    override val layoutRes: Int
        get() = R.layout.activity_preview_image

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreated(instance: Bundle?) {

        checkExtras()
        initViews()
        initObserver()
    }

    private fun initViews() {

        binding.previewIbClose.setOnClickListener { finish() }
    }

    private fun initObserver() {
        viewModel.apply {
        }
        binding.lifecycleOwner = this
//        binding.vm = viewModel
    }

    private fun checkExtras() {
        intent.extras?.apply {
            if (containsKey(EXTRA_FILE_URL)){

                with(getString(EXTRA_FILE_URL, "")) {
                    when {
                        contains(".mp4") -> {
                            binding.previewVvVideo.visibility = View.VISIBLE

                            videoPlayer = this.let { SimpleExoPlayer.Builder(this@PreviewImageActivity).build() }
                            binding.previewVvVideo.player = videoPlayer
                            videoPlayer.setMediaItem(MediaItem.fromUri(getString(EXTRA_FILE_URL, "")))
                            videoPlayer.prepare()
                            videoPlayer.play()

                        }
                        contains(".pdf") -> {
                            binding.previewPdfvPdf.visibility = View.VISIBLE
                            FileLoader.with(this@PreviewImageActivity)
                                .load(getString(EXTRA_FILE_URL, ""), false)
                                .fromDirectory("PDF", FileLoader.DIR_INTERNAL)
                                .asFile(object: FileRequestListener<File> {
                                    override fun onLoad(request: FileLoadRequest?, response: FileResponse<File>?) {
                                        binding.previewPdfvPdf.fromFile(response!!.body)
                                            .password(null)
                                            .spacing(100)
                                            .enableDoubletap(true)
                                            .defaultPage(0)
                                            .load()
                                    }
                                    override fun onError(request: FileLoadRequest?, t: Throwable?) { /*showMessage("Something went wrong", false)*/ }
                                })
                        }
                        else -> {
                            binding.previewZivImage.visibility = View.VISIBLE
                            Glide.with(binding.previewZivImage.context)
                                .load(this)
                                .into(binding.previewZivImage)
                        }
                    }
                }
            } else {
                finish()
            }
        }
    }


    companion object {
        const val EXTRA_FILE_URL = "file_url"
    }
}