package com.findajob.jobamax.dashboard.messages

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.databinding.FragmentChatsBinding
import com.findajob.jobamax.dialog.ConfirmationDialog
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.util.ARG_REFRESH_ACTIVE
import com.findajob.jobamax.util.log
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@AndroidEntryPoint
class JobSeekerChatsFragment : BaseFragmentMain<FragmentChatsBinding>() {

    private val viewModel: MessagesViewModel by activityViewModels()

    override fun getViewModel(): BaseViewModel = viewModel

    @Inject
    lateinit var messagesAdapter: MessagesAdapter

    lateinit var newPeopleAdapter: NewPeopleAdapter

    lateinit var currentUserId: String


    override val layoutRes: Int
        get() = R.layout.fragment_chats

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        initObserver()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getMessages(MessageType.JOB)
        viewModel.getNewUsers(requireActivity().getRole())
        FirebaseMessaging.getInstance()
            .subscribeToTopic("/topics/$ARG_REFRESH_ACTIVE")
        requireActivity().registerReceiver(broadcastReceiver, IntentFilter(ARG_REFRESH_ACTIVE))
    }


    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            viewModel.getNewUsers(requireActivity().getRole())
        }
    }

    override fun onDestroy() {
        requireActivity().unregisterReceiver(broadcastReceiver)
        super.onDestroy()
    }

    private fun initViews() {

        log("job seeker chats fragment  is started")
        binding.apply {
            loading.visibility = View.VISIBLE
            loading.start()

            messagesAdapter = MessagesAdapter()

            messagesAdapter.currentUserId = viewModel.currentUserId


            messagesRvMessages.adapter = messagesAdapter

            val horizontalLayoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            messagesRvNewPeople.layoutManager = horizontalLayoutManager

            newPeopleAdapter = NewPeopleAdapter()
            messagesRvNewPeople.adapter = newPeopleAdapter

//            itemTouchHelper.attachToRecyclerView(messagesRvMessages)
        }

        messagesAdapter.clickListener = { message ->
            viewModel.makeMessageSeen(message)
            goToChatActivity(message)
        }

        messagesAdapter.deleteButtonClickListener = { message ->
            var isDeleted = false
            isDeleted = showDeleteDialog(message)
            isDeleted
        }

        messagesAdapter.shortListButtonClickListener = { message ->
            var isShortListed = false
            isShortListed = showShortListDialog(message)
            isShortListed
        }

        newPeopleAdapter.clickListener = { newPeople ->
            activity?.goToActivity(
                ChatActivity::class.java,
                false,
                bundleOf(
                    Pair(ChatActivity.EXTRA_RECEIVER_ID, newPeople.objectId),
                    Pair(ChatActivity.EXTRA_PROFILE_PICTURE_URL, newPeople.profilePicUrl),

                    )
            )
        }


        binding.messageSearchView.setOnQueryTextListener(
            object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    messagesAdapter.filter.filter(query)
                    newPeopleAdapter.filter.filter(query)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    messagesAdapter?.filter?.filter(newText)
                    newPeopleAdapter?.filter?.filter(newText)
                    return true
                }

            }
        )


    }

    private fun goToChatActivity(message: Message) {

        lifecycleScope.launch(Dispatchers.IO) {
            val receiverIdPair = Pair(
                ChatActivity.EXTRA_RECEIVER_ID,
                if (message.receiverId.objectId == currentUserId)
                    message.senderId.objectId
                else message.receiverId.objectId
            )

            val profilePictureUrlPair = Pair(
                ChatActivity.EXTRA_PROFILE_PICTURE_URL,

                if (message.receiverId.objectId == currentUserId)
                    message.senderId.get("profilePicUrl").toString()
                else
                    message.receiverId.get("profilePicUrl").toString()
            )

            val messageObjectIdPair = Pair(
                ChatActivity.EXTRA_MESSAGE_OBJECT_ID,
                message.objectId,
            )

            withContext(Dispatchers.Main) {
                activity?.goToActivity(
                    ChatActivity::class.java,
                    false,
                    bundleOf(receiverIdPair, profilePictureUrlPair, messageObjectIdPair),
                )
            }
        }

    }

    private fun showDeleteDialog(message: Message): Boolean {
        var isDeleted = false
        ConfirmationDialog(
            requireActivity(),
            "Are you sure?",
            "Delete",
            "Cancel",
            true,
        ) { buttonClicked ->
            if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
                deleteConversation(message)
                isDeleted = true
            } else {
                isDeleted = false
            }
        }.show()

        return isDeleted
    }

    private fun showShortListDialog(message: Message): Boolean {
        var isShortListed = true

        if (!message.shortListedBy.contains(currentUserId)) {
            ConfirmationDialog(
                requireActivity(),
                "Would you like to shortlist\nthis person?",
                "Confirm",
                "Cancel",
                true,
            ) { buttonClicked ->
                if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
                    shortListConversation(message)
                    isShortListed = true
                } else {
                    isShortListed = false
                }
            }.show()
        } else {
            ConfirmationDialog(
                requireActivity(),
                "Remove from shortlist?",
                "Confirm",
                "Cancel",
                true,
            ) { buttonClicked ->
                if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
                    removeFromShortlist(message)
                    isShortListed = false
                } else {
                    isShortListed = true
                }
            }.show()

        }
        return isShortListed
    }

    private fun shortListConversation(message: Message) {
        viewModel.shortListAUser(message)
        messagesAdapter.notifyDataSetChanged()
    }

    private fun removeFromShortlist(message: Message) {
        viewModel.removeFromShortlist(message)
        messagesAdapter.notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun deleteConversation(message: Message) {
        message.deleteInBackground()

        viewModel.deleteChat(
            if (message.receiverId.objectId == viewModel.currentUserId)
                message.senderId.objectId ?: ""
            else
                message.receiverId.objectId ?: ""
        )

        viewModel.unmatchUser(
            requireActivity().getRole(),
            if (message.receiverId.objectId == viewModel.currentUserId)
                message.senderId.objectId
            else
                message.receiverId.objectId
        )

        // this will improve the perceived performance of message deletion

        messagesAdapter.remoteAnItem(message)
        messagesAdapter.notifyDataSetChanged()

    }

    private fun initObserver() {

        binding.lifecycleOwner = this

        currentUserId = viewModel.currentUserId

        viewModel.apply {
            getMessages(MessageType.JOB)
            observe(jobSeekerMessages) {
                binding.loading.visibility = View.INVISIBLE
                log("messages $it")
                it?.let {
                    messagesAdapter.submitList(it!!)
                    messagesAdapter.filterCollection = it!!
                }
            }
        }

        viewModel.apply {
            getNewUsers(requireActivity().getRole())
            observe(newUsers) {
                it?.let {
                    newPeopleAdapter.submitList(it)
                    newPeopleAdapter.filterCollection = it!!
                    newPeopleAdapter.notifyDataSetChanged()
                }
            }
        }


    }

    companion object {
        fun newInstance() = JobSeekerChatsFragment()
    }
}