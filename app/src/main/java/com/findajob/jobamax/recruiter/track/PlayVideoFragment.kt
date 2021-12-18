package com.findajob.jobamax.recruiter.track

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.findajob.jobamax.R
import com.findajob.jobamax.util.ARG_LOCATION
import com.findajob.jobamax.util.ARG_VIDEO_URL
import com.findajob.jobamax.util.log
import kotlinx.android.synthetic.main.fragment_play_video.*

class PlayVideoFragment : Fragment() {
	
	var url = ""
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		url = arguments?.getString(ARG_VIDEO_URL, "") ?: ""
		log("Video Url: $url")
	}
	
	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_play_video, container, false)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		videoView.setVideoPath(url)
		
		videoView.setOnPreparedListener {
			progressBar.visibility = View.GONE
		}
		videoView.start()
	}
	
}