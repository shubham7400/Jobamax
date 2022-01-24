package com.findajob.jobamax.dashboard.messages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.data.pojo.Category
import com.findajob.jobamax.databinding.FragmentChatUserListBinding
import com.findajob.jobamax.databinding.ItemChatUserHorizontalBinding
import com.findajob.jobamax.databinding.ItemChatUserVerticalBinding


class ChatUserListFragment : Fragment() {
     lateinit var binding: FragmentChatUserListBinding

    var userListHorizontal = arrayListOf("a","b","c","a","b","c","a","b","c")
    var userListVertical = arrayListOf("a","b","c","a","b","c","a","b","c")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatUserListBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }

    private fun configureUi() {
        setClickListeners()
        val chatUserHorizontalAdapter = ChatUserHorizontalAdapter(userListHorizontal)
        binding.rvChatUserHorizontal.adapter = chatUserHorizontalAdapter
        chatUserHorizontalAdapter.clickListener = {
            (activity as MainChatActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, ChatMessageBoardFragment())
                .addToBackStack("backStackStateName")
                .commit()
        }
        val chatUserVerticalAdapter = ChatUserVerticalAdapter(userListVertical)
        binding.rvChatUserVertical.adapter = chatUserVerticalAdapter
        chatUserVerticalAdapter.clickListener = {
            (activity as MainChatActivity).supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, ChatMessageBoardFragment())
                .addToBackStack("backStackStateName")
                .commit()
        }
    }

    private fun setClickListeners() {
        binding.ivBackButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}

class ChatUserHorizontalAdapter(private val userList: ArrayList<String>) : RecyclerView.Adapter<ChatUserHorizontalAdapter.ViewHolder>() {
    internal var clickListener: () -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemChatUserHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.ivUser.setOnClickListener {
            clickListener()
        }
    }
    override fun getItemCount(): Int = userList.size
    class ViewHolder(val binding: ItemChatUserHorizontalBinding) : RecyclerView.ViewHolder(binding.root)
}

class ChatUserVerticalAdapter(private val userList: ArrayList<String>) : RecyclerView.Adapter<ChatUserVerticalAdapter.ViewHolder>() {
    internal var clickListener: () -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(ItemChatUserVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.clUser.setOnClickListener {
            clickListener()
        }
    }
    override fun getItemCount(): Int = userList.size
    class ViewHolder(val binding: ItemChatUserVerticalBinding) : RecyclerView.ViewHolder(binding.root)
}
