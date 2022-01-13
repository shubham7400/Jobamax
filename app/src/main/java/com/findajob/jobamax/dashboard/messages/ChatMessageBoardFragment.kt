package com.findajob.jobamax.dashboard.messages

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
 import androidx.recyclerview.widget.RecyclerView
 import com.findajob.jobamax.databinding.FragmentChatMessageBoardBinding
import com.findajob.jobamax.databinding.ItemMessageImageBinding
import com.findajob.jobamax.databinding.ItemMessageTextBinding
import com.findajob.jobamax.databinding.ItemMessageVideoBinding
import kotlinx.android.synthetic.main.item_message_image.view.*
import kotlinx.android.synthetic.main.item_message_text.view.*
 import androidx.fragment.app.DialogFragment
import com.findajob.jobamax.dashboard.messages.ChatMessageBoardAdapter.Companion.IMAGE_VIEW_TYPE
import com.findajob.jobamax.dashboard.messages.ChatMessageBoardAdapter.Companion.VIDEO_VIEW_TYPE
import com.findajob.jobamax.preference.getUserId
import com.findajob.jobamax.util.loadImageFromUrl
import kotlinx.android.synthetic.main.item_message_video.view.*
import java.io.Serializable


class ChatMessageBoardFragment : Fragment() {
    lateinit var binding: FragmentChatMessageBoardBinding
   /* val types = arrayListOf(1,2,1,1,2,3,1,2,2,3,3,3,1)*/
    var types = arrayListOf<Mes>(
        Mes(1, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","abcsfkla sjhd sde"),
        Mes(2, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","adfssfbc df eifjj"),
        Mes(1, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","abdsfewc dgdkf ddgkd djkrti fjsdj sieri djfksfk fdskfls "),
        Mes(3, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","abccdfsa"),
        Mes(1, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","abseefcc"),
        Mes(1, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","abdfdsc"),
        Mes(2, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","abccc"),
        Mes(2, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","abrwwdc"),
        Mes(1, "23435", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","","abdggfdc"),
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatMessageBoardBinding.inflate(inflater, container, false)
        configureUi()
        return binding.root
    }
    private fun configureUi() {
        val chatMessageBoardAdapter = ChatMessageBoardAdapter(types, requireContext())
        binding.rvMessages.adapter = chatMessageBoardAdapter
        binding.rvMessages.scrollToPosition(types.size - 1)
        chatMessageBoardAdapter.imageClickListener = {
            showDialog(IMAGE_VIEW_TYPE, it)
        }
        chatMessageBoardAdapter.videoClickListener = {
            showDialog(VIDEO_VIEW_TYPE, it)
        }

        binding.ivLike.setOnClickListener {
            if (binding.etMessage.text.isNotEmpty()){
                types.add(Mes(1, context?.getUserId().toString(), "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg", "https://parsefiles.back4app.com/s3gwYWzFlAYgtfSLTNWZVp6wpTQwj5ISs5XgF7lL/c8b313e9df7b40df04941f7c1606e9b8_2.jpg","",binding.etMessage.text.toString()),)
                binding.etMessage.text.clear()
                chatMessageBoardAdapter.notifyDataSetChanged()
                binding.rvMessages.scrollToPosition(types.size - 1)
            }
        }
    }

    private fun showDialog(viewType: Int, mes: Mes) {
        val newFragment: DialogFragment = DisplayChatItemDialogFragment.newInstance(viewType, mes)
        newFragment.show(requireFragmentManager(), "dialog")
    }
}

class ChatMessageBoardAdapter(private val messageList: ArrayList<Mes>, val requireContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var imageClickListener: ( Mes) -> Unit = {}
    var videoClickListener: ( Mes) -> Unit = {}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  when (viewType) {
            TEXT_VIEW_TYPE -> {
                TextViewHolder(ItemMessageTextBinding.inflate(LayoutInflater.from(parent.context),parent, false))
            }
            IMAGE_VIEW_TYPE -> {
                ImageViewHolder(ItemMessageImageBinding.inflate(LayoutInflater.from(parent.context),parent, false))
            }
            else -> {
                VideoViewHolder(ItemMessageVideoBinding.inflate(LayoutInflater.from(parent.context),parent, false))
            }
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val mesObj = messageList[position]
        when(mesObj.messageType){
            TEXT_VIEW_TYPE -> {
                holder.itemView.tv_message_user.text = mesObj.textMessage
                if (mesObj.senderId == requireContext.getUserId()){
                    holder.itemView.rl_text_message.gravity = Gravity.END
                }else{
                    holder.itemView.rl_text_message.gravity = Gravity.START
                }
            }
            IMAGE_VIEW_TYPE -> {
                loadImageFromUrl(holder.itemView.iv_user, mesObj.imageUrl)
                holder.itemView.iv_user.setOnClickListener {
                    imageClickListener(mesObj)
                }
            }
            VIDEO_VIEW_TYPE -> {
                loadImageFromUrl(holder.itemView.iv_video_thumbnail, mesObj.videoThumbnailUrl)
                holder.itemView.video_view_message_user.setOnClickListener {
                    videoClickListener(mesObj)
                }
            }
        }
    }
    override fun getItemCount(): Int = messageList.size
    override fun getItemViewType(position: Int): Int {
        return messageList[position].messageType
    }

    private inner class TextViewHolder(binding: ItemMessageTextBinding ) : RecyclerView.ViewHolder(binding.root)
    private inner class ImageViewHolder(binding: ItemMessageImageBinding) : RecyclerView.ViewHolder(binding.root)
    private inner class VideoViewHolder(binding: ItemMessageVideoBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        const val TEXT_VIEW_TYPE = 1
        const val IMAGE_VIEW_TYPE = 2
        const val VIDEO_VIEW_TYPE = 3
    }
}

data class Mes(val messageType: Int, val senderId: String, val imageUrl: String, val videoThumbnailUrl: String, val videoUrl: String, val textMessage: String) : Serializable