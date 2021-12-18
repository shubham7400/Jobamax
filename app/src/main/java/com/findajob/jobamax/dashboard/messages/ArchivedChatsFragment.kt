package com.findajob.jobamax.dashboard.messages

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.base.BaseViewModel
import com.findajob.jobamax.data.pojo.Message
import com.findajob.jobamax.databinding.FragmentArchivedChatsBinding
import com.findajob.jobamax.dialog.ConfirmationDialog
import com.findajob.jobamax.extensions.goToActivity
import com.findajob.jobamax.extensions.observe
import com.findajob.jobamax.preference.getRole
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArchivedChatsFragment : BaseFragmentMain<FragmentArchivedChatsBinding>() {

    override val layoutRes: Int
        get() = R.layout.fragment_archived_chats

    private val viewModel: MessagesViewModel by activityViewModels()

    override fun getViewModel(): BaseViewModel = viewModel

    val archivedMessagesAdapter: ArchivedMessageAdapter by lazy {
        ArchivedMessageAdapter()
    }

    lateinit var currentUserId: String

    override fun onCreated(savedInstance: Bundle?) {
        initViews()
        initObserver()
    }

    override fun onStart() {
        super.onStart()
        viewModel.getMessages(MessageType.ARCHIVING)
    }

    private fun initViews() {
        binding.lifecycleOwner = this

        binding.apply {
            loading.visibility = View.VISIBLE
            loading.start()
            archivedMessagesAdapter.currentUserId = viewModel.currentUserId
            messagesRvMessages.adapter = archivedMessagesAdapter
        }

        archivedMessagesAdapter.clickListener = { message ->
            viewModel.makeMessageSeen(message)
            goToChatActivity(message)
        }



        archivedMessagesAdapter.unarchiveButtonListener = { message ->
//            var isShortListed = false
            showUnarchiveDialog(message)
//            isShortListed = showShortListDialog(message)
//            isShortListed
            true
        }


        binding.messageSearchView.setOnQueryTextListener(queryTextListener)


    }

    private val queryTextListener =
        object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                archivedMessagesAdapter.filter.filter(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                archivedMessagesAdapter.filter.filter(newText)
                return true
            }

        }

    private fun goToChatActivity(message: Message) {
        lifecycleScope.launch(Dispatchers.IO) {
            val extraReceiverId = Pair(
                ChatActivity.EXTRA_RECEIVER_ID,
                if (message.receiverId.objectId == currentUserId)
                    message.senderId.objectId
                else message.receiverId.objectId
            )

            val extraProfilePictureUrl = Pair(
                ChatActivity.EXTRA_PROFILE_PICTURE_URL,

                if (message.receiverId.objectId == currentUserId)
                    message.senderId.get("profilePicUrl").toString()
                else
                    message.receiverId.get("profilePicUrl").toString()
            )

            val extraMessageSource =
                Pair(ChatActivity.EXTRA_MESSAGE_SOURCE, MessageType.ARCHIVING.param)

            withContext(Dispatchers.Main) {
                activity?.goToActivity(
                    ChatActivity::class.java,
                    false,
                    bundleOf(extraReceiverId, extraProfilePictureUrl, extraMessageSource),
                )
            }
        }

    }


    private fun showUnarchiveDialog(message: Message): Boolean {
        var isUnarchived = true

        if (viewModel.isArchivePossible) {
            ConfirmationDialog(
                requireActivity(),
                "Would you like to unarchive the message?",
                "Confirm",
                "Cancel",
                true,
            ) { buttonClicked ->
                if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
                    unarchiveConversation(message)
                    isUnarchived = true
                    viewModel.increaseCurrentCount()
                } else {
                    isUnarchived = false
                }
            }.show()
        } else {
            ConfirmationDialog(
                requireActivity(),
                "Your archiving capacity has reached its limit. Would you like to upgrade your plan",
                "Upgrade",
                "Cancel",
                true,
            ) { buttonClicked ->
                if (buttonClicked == ConfirmationDialog.CallConfirmationButton.POSITIVE) {
                    viewModel.refillArchiveCount()
                } else {
                    toast("You need to upgrade to continue archiving.")
                }
                // todo: need to implement redirecting to upgrade plan
            }.show()

        }
        return isUnarchived
    }

    private fun unarchiveConversation(message: Message) = viewModel.unarchiveConversation(message)

    private fun deleteConversation(message: Message) {
        viewModel.deleteMessage(message)

//        viewModel.deleteChat(
//            if (message.receiverId.objectId == viewModel.currentUserId)
//                message.senderId.objectId ?: ""
//            else
//                message.receiverId.objectId ?: ""
//        )

        viewModel.unmatchUser(
            requireActivity().getRole(),
            if (message.receiverId.objectId == viewModel.currentUserId)
                message.senderId.objectId
            else
                message.receiverId.objectId
        )

        archivedMessagesAdapter.removeAnItem(message)
    }

    private fun initObserver() {

        currentUserId = viewModel.currentUserId

        binding.loading.visibility = View.INVISIBLE

        viewModel.apply {

            getMessages(MessageType.ARCHIVING)

            observe(archivedMessages) {
                binding.loading.visibility = View.INVISIBLE
                log("messages $it")
                it?.let { messageList ->
                    archivedMessagesAdapter.submitList(messageList)
                    archivedMessagesAdapter.filterCollection = messageList
                }
            }
        }

    }

    companion object {
        fun newInstance() = ArchivedChatsFragment()
    }
}