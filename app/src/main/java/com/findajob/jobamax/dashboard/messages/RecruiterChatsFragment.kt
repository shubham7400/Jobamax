package com.findajob.jobamax.dashboard.messages

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.databinding.FragmentRecruiterChatsBinding
import com.findajob.jobamax.dialog.ConfirmationDialog
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.recruiter.profile.jobOffer.MessageFilterJobOfferDialog
import com.findajob.jobamax.repo.MessageRepository
import com.findajob.jobamax.util.ARG_REFRESH_ACTIVE
import com.findajob.jobamax.util.log
import com.google.firebase.messaging.FirebaseMessaging
import com.parse.ParseUser
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RecruiterChatsFragment : BaseFragmentMain<FragmentRecruiterChatsBinding>() {

    private val viewModel: MessagesViewModel by activityViewModels()

    override fun getViewModel(): BaseViewModel = viewModel

    lateinit var messagesAdapter: MessagesAdapter

    lateinit var newPeopleAdapter: NewPeopleAdapter

    lateinit var currentUserId: String


    override val layoutRes: Int
        get() = R.layout.fragment_recruiter_chats

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

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().unregisterReceiver(broadcastReceiver)
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            viewModel.getNewUsers(requireActivity().getRole())
        }
    }

    private fun initViews() {

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

            activity?.goToActivity(
                ChatActivity::class.java,
                false,
                bundleOf(
                    Pair(
                        ChatActivity.EXTRA_RECEIVER_ID,
                        if (message.receiverId.objectId == currentUserId)
                            message.senderId.objectId
                        else message.receiverId.objectId
                    ),
                    Pair(
                        ChatActivity.EXTRA_PROFILE_PICTURE_URL,

                        if (message.receiverId.objectId == currentUserId)
                            message.senderId.get("profilePicUrl").toString()
                        else
                            message.receiverId.get("profilePicUrl").toString()
                    ),
                    Pair(
                        ChatActivity.EXTRA_MESSAGE_OBJECT_ID,
                        message.objectId,
                    )
                ),
            )
        }

        messagesAdapter.deleteButtonClickListener = { message ->
            val isDeleted: Boolean = showDeleteDialog(message)
            isDeleted
        }

        messagesAdapter.shortListButtonClickListener = { message ->
            val isShortListed = showShortListDialog(message)
            isShortListed
        }

        newPeopleAdapter.clickListener = {
            activity?.goToActivity(
                ChatActivity::class.java,
                false,
                bundleOf(
                    Pair(ChatActivity.EXTRA_RECEIVER_ID, it.objectId),
                    Pair(ChatActivity.EXTRA_PROFILE_PICTURE_URL, it.profilePicUrl),
                )
            )
        }

        binding.offerFilters.setOnClickListener {
            onJobOfferClicked()
        }

        binding.messageSearchView.setOnQueryTextListener(
            object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    messagesAdapter.filter.filter(query)
                    newPeopleAdapter.filter.filter(query)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    messagesAdapter.filter.filter(newText)
                    newPeopleAdapter.filter.filter(newText)
                    return true
                }

            }
        )


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
            isDeleted = if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
                deleteConversation(message)
                true
            } else {
                false
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
        messagesAdapter.notifyDataSetChanged()
        viewModel.shortListAUser(message)
    }

    private fun removeFromShortlist(message: Message) {
        messagesAdapter.notifyDataSetChanged()
        viewModel.removeFromShortlist(message)
    }

    private fun deleteConversation(message: Message) {
        message.deleteInBackground()

        viewModel.deleteChat(
            if (message.receiverId.objectId == ParseUser.getCurrentUser().objectId)
                message.senderId.objectId ?: ""
            else
                message.receiverId.objectId ?: ""
        )

        viewModel.unmatchUser(
            requireActivity().getRole(),
            if (message.receiverId.objectId == ParseUser.getCurrentUser().objectId)
                message.senderId.objectId
            else
                message.receiverId.objectId
        )

        // this will improve the perceived performance of message deletion
        val arrList = arrayListOf<Message>()

        arrList.addAll(messagesAdapter.getCurrentList())
        arrList.remove(message)

        messagesAdapter.submitList(arrList.toList())
        messagesAdapter.filterCollection = arrList.toList()

        messagesAdapter.notifyDataSetChanged()

    }

    private fun initObserver() {

        currentUserId = viewModel.currentUserId
        context?.let {
            viewModel.loadJobOffers(it.getUserId(), object : MessageRepository.GetOffersCallback {
                override fun onFinish() {
                }
            })
        }

        viewModel.apply {
            getMessages(MessageType.JOB)
            observe(jobSeekerMessages) {
                binding.loading.visibility = View.INVISIBLE
                log("messages $it")
                it?.let {
                    messagesAdapter.submitList(it)
                    messagesAdapter.filterCollection = it
                }
            }
        }

        viewModel.apply {
            getNewUsers(requireActivity().getRole())
            observe(newUsers) {
                it?.let {
                    newPeopleAdapter.submitList(it)
                    newPeopleAdapter.filterCollection = it
                }
            }
        }


        binding.lifecycleOwner = this
    }

    private fun onJobOfferClicked() {
        viewModel.apply {
            MessageFilterJobOfferDialog(requireActivity(), allJobOffers) { offer ->
                getFilteredOfferMessages(offer)
                getFilteredOfferMatches(offer)
            }.show()
        }

    }

    companion object {
        fun newInstance() = RecruiterChatsFragment()
    }
}