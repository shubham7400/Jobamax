package com.findajob.jobamax.training.ui

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.PorterDuff
import android.media.AudioManager
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentLiveRoomBinding
import com.findajob.jobamax.dialog.LeaveRoomDialog
import com.findajob.jobamax.dialog.RoomInviteDialog
import com.findajob.jobamax.model.LiveRoom
import com.findajob.jobamax.training.model.AGEventHandler
import com.findajob.jobamax.util.ARG_REFRESH_ROOM
import com.findajob.jobamax.util.log
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint
import io.agora.rtc.Constants
import kotlinx.android.synthetic.main.fragment_live_room.*
import org.slf4j.LoggerFactory

@AndroidEntryPoint
class LiveRoomFragment : BaseFragmentMain<FragmentLiveRoomBinding>(), AGEventHandler,
    LiveRoomInterface {

    val viewModel: ManageRoomViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }

    private var mAudioMuted = false
    private var mHandRaised = false

    private val mAudioRouting = -1 // Default

    override val layoutRes: Int
        get() = R.layout.fragment_live_room

    override fun onCreated(savedInstance: Bundle?) {
        viewModel.initRoom()
        binding.handler = this
    }


    private fun subscribeObserver() {
        viewModel.membersLiveData.observe(viewLifecycleOwner, { memberList ->
            progressHud.dismiss()
            rv_location_list.layoutManager = GridLayoutManager(requireContext(), 4)
            rv_location_list.adapter = activity?.let { activity ->
                LiveRoomMemberAdapter(activity, memberList)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressHud.show()
        subscribeObserver()
        (requireActivity() as ManageRoomActivity).event().addEventHandler(this)
        doConfigEngine(Constants.CLIENT_ROLE_BROADCASTER)
        broadcasterUI(mute_local_speaker_id)
        val roomName = LiveRoom(viewModel.selectedRoom!!).name
        (requireActivity() as ManageRoomActivity).worker()
            .joinChannel(roomName, (requireActivity() as ManageRoomActivity).config().mUid)
        room_name.text = roomName
        requireActivity().volumeControlStream = AudioManager.STREAM_VOICE_CALL
    }

    fun onSwitchSpeakerClicked(view: View) {
        log.info("onSwitchSpeakerClicked $view $mAudioMuted $mAudioRouting")
        val rtcEngine = (requireActivity() as ManageRoomActivity).rtcEngine()
        // Enables/Disables the audio playback route to the speakerphone.
        // This method sets whether the audio is routed to the speakerphone or earpiece. After calling this method, the SDK returns the onAudioRouteChanged callback to indicate the changes.
        rtcEngine.setEnableSpeakerphone(mAudioRouting != 3)
    }

    private fun doConfigEngine(cRole: Int) {
        (requireActivity() as ManageRoomActivity).worker().configEngine(cRole)
    }

    private fun isBroadcaster(cRole: Int): Boolean {
        return cRole == Constants.CLIENT_ROLE_BROADCASTER
    }

    private val isBroadcaster: Boolean
        get() = isBroadcaster((requireActivity() as ManageRoomActivity).config().mClientRole)


    private fun doLeaveChannel() {
        (requireActivity() as ManageRoomActivity).worker()
            .leaveChannel((requireActivity() as ManageRoomActivity).config().mChannel)
    }

    override fun onStart() {
        super.onStart()
        FirebaseMessaging.getInstance()
            .subscribeToTopic("/topics/" + LiveRoom(viewModel.selectedRoom!!).roomId)
        requireActivity().registerReceiver(broadcastReceiver, IntentFilter(ARG_REFRESH_ROOM))
    }


    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            viewModel.loadRoom()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        FirebaseMessaging.getInstance()
            .unsubscribeFromTopic("/topics/" + LiveRoom(viewModel.selectedRoom!!).roomId)
        viewModel.removeMember()
        doLeaveChannel()
        requireActivity().unregisterReceiver(broadcastReceiver)
        (requireActivity() as ManageRoomActivity).event().removeEventHandler(this)

    }

    private fun audienceUI(button2: ImageView) {
        button2.tag = null
        button2.visibility = View.GONE
        button2.clearColorFilter()
    }

    private fun broadcasterUI(button2: ImageView) {
        button2.setOnClickListener { v: View ->
            val tag = v.tag
            var flag = true
            if (tag != null && tag as Boolean) {
                flag = false
            }
            (requireActivity() as ManageRoomActivity).worker().rtcEngine.muteLocalAudioStream(flag)
            val button = v as ImageView
            button.tag = flag
            if (flag) {
                button.setColorFilter(
                    resources.getColor(R.color.colorAccent),
                    PorterDuff.Mode.MULTIPLY
                )
            } else {
                button.clearColorFilter()
            }
        }
        button2.visibility = View.VISIBLE
    }

    override fun onVoiceMuteClicked() {
        log.info("onVoiceMuteClicked audio_status: $mAudioMuted")
        val rtcEngine = (requireActivity() as ManageRoomActivity).rtcEngine()
        // Stops/Resumes sending the local audio stream.
        // A successful muteLocalAudioStream method call triggers the onUserMuteAudio callback on the remote client.
        mAudioMuted = !mAudioMuted
        rtcEngine.muteLocalAudioStream(mAudioMuted)
        if (mAudioMuted) {
            mute_local_speaker_id.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.colorAccent
                ), PorterDuff.Mode.MULTIPLY
            )
        } else {
            mute_local_speaker_id.clearColorFilter()
        }
        viewModel.muteAudio(mAudioMuted)
    }

    override fun raiseHand() {
        mHandRaised = !mHandRaised
        if (mHandRaised) {
            raise_hand.setColorFilter(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.transGrey
                ), PorterDuff.Mode.MULTIPLY
            )
        } else {
            raise_hand.clearColorFilter()
        }
        viewModel.raiseHand(mHandRaised)
    }

    override fun onJoinChannelSuccess(channel: String?, uid: Int, elapsed: Int) {
        val msg = "onJoinChannelSuccess $channel $elapsed"
        log(msg)
    }

    override fun onUserOffline(uid: Int, reason: Int) {
        val msg = "onUserOffline $reason"
        log(msg)
    }

    override fun onExtraCallback(type: Int, vararg data: Any?) {

    }

    override fun onBackButtonClicked() {
        LeaveRoomDialog(
            requireActivity(),
        ) { button ->
            if (button == LeaveRoomDialog.SubmitButton.POSITIVE) {
                requireActivity().onBackPressed()
            }
        }.show()
    }

    override fun inviteMember() {
        RoomInviteDialog(viewModel, requireActivity()).show()
    }

    /* public void notifyHeadsetPlugged(final int routing) {
        log.info("notifyHeadsetPlugged " + routing);
        mAudioRouting = routing;
        ImageView iv = (ImageView) findViewById(R.id.switch_speaker_id);
        if (mAudioRouting == 3) { // Speakerphone
            iv.setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
        } else {
            iv.clearColorFilter();
        }
    }*/

    companion object {
        private val log = LoggerFactory.getLogger(LiveRoomFragment::class.java)
    }
}