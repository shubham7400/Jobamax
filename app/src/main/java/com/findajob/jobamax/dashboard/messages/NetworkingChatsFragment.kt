package com.findajob.jobamax.dashboard.messages

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.databinding.FragmentNetworkingChatsBinding
import com.findajob.jobamax.dialog.ConfirmationDialog
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.util.CHAT_IS_NETWORKING
import com.findajob.jobamax.util.log
import com.parse.ParseUser

class NetworkingChatsFragment : BaseFragmentMain<FragmentNetworkingChatsBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_networking_chats

    private val viewModel: MessagesViewModel by activityViewModels()

    override fun getViewModel(): BaseViewModel = viewModel

    lateinit var networkingMessagesAdapter: MessagesAdapter

    lateinit var currentUserId: String

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        initObserver()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getMessages(MessageType.NETWORKING)
    }

    private fun initViews() {

        binding.apply {
            loading.visibility = View.VISIBLE
            loading.start()

            networkingMessagesAdapter = MessagesAdapter()

            networkingMessagesAdapter.currentUserId = viewModel.currentUserId


            messagesRvMessages.adapter = networkingMessagesAdapter


        }

        networkingMessagesAdapter.clickListener = { message ->
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
                    Pair(ChatActivity.EXTRA_MESSAGE_SOURCE, CHAT_IS_NETWORKING)
                ),
            )
        }

        networkingMessagesAdapter.deleteButtonClickListener = { message ->
            var isDeleted = false
            isDeleted = showDeleteDialog(message)
            isDeleted
        }

        networkingMessagesAdapter.shortListButtonClickListener = { message ->
            var isShortListed = false
            isShortListed = showShortListDialog(message)
            isShortListed
        }


        binding.messageSearchView.setOnQueryTextListener(
            object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    networkingMessagesAdapter?.filter?.filter(query)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    networkingMessagesAdapter?.filter?.filter(newText)
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

    fun shortListConversation(message: Message) {
        viewModel.shortListAUser(message)
        networkingMessagesAdapter.notifyDataSetChanged()
    }

    fun removeFromShortlist(message: Message) {
        viewModel.removeFromShortlist(message)
        networkingMessagesAdapter.notifyDataSetChanged()
    }

    fun deleteConversation(message: Message) {
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

        arrList.addAll(networkingMessagesAdapter.getCurrentList())
        arrList.remove(message)

        networkingMessagesAdapter.submitList(arrList.toList())
        networkingMessagesAdapter.filterCollection = arrList.toList()

        networkingMessagesAdapter.notifyDataSetChanged()

    }

    private fun initObserver() {

        currentUserId = viewModel.currentUserId

        viewModel.apply {
            getMessages(MessageType.NETWORKING)
            observe(networkingMessages) {
                binding.loading.visibility = View.INVISIBLE
                log("messages $it")
                it?.let {
                    networkingMessagesAdapter.submitList(it!!)
                    networkingMessagesAdapter.filterCollection = it!!
                }
            }
        }

        binding.lifecycleOwner = this
    }

    companion object {
        fun newInstance() = NetworkingChatsFragment()
    }
}