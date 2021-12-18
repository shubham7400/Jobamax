package com.findajob.jobamax.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.findajob.jobamax.R
import com.findajob.jobamax.training.model.Member


class MessagePopUpDialog(
    private val activity: Activity,
    private val friend: Member,
    val handleFriendRequest: (accepted: Boolean) -> Unit
) : Dialog(activity) {


    private lateinit var tvSkipButton: TextView
    private lateinit var ivProfilePic: ImageView
    private lateinit var tvName: TextView
    private lateinit var btnMessage: Button
    private lateinit var rvSocialMedias: RecyclerView
    private lateinit var mutualFriendImageArrayAdapter: MutualFriendAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews() // initialises the views to variables and sets visual elements up for a dialog
        setUpObserver() // observes the views
        loadUi() // loads the ui after the data is processed
    }


    private fun loadUi() {
        tvName.text = friend.name

        ivProfilePic.load(friend.profileUrl)

        val demoSocialMediaList = listOf<String>("facebook", "twitter")

        mutualFriendImageArrayAdapter = MutualFriendAdapter(demoSocialMediaList)

        val horizontalLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        rvSocialMedias.apply {
            layoutManager = horizontalLayoutManager
            adapter = mutualFriendImageArrayAdapter
        }
    }

    private fun setUpObserver() {


        tvSkipButton.setOnClickListener {
            handleFriendRequest(false)
            dismiss()
        }

        btnMessage.setOnClickListener {
            handleFriendRequest(true)
            dismiss()
        }
    }


    private fun initViews() {

        requestWindowFeature(Window.FEATURE_NO_TITLE)

        // sets the layout
        setContentView(R.layout.dialog_message_pop_up)

        window?.setLayout(
            RelativeLayout.LayoutParams.MATCH_PARENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )

        // the background color should be transparent, if not,
        // the rounded border will not work
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        // initialises the view variables
        tvSkipButton = findViewById(R.id.tvSkipButton)
        rvSocialMedias = findViewById(R.id.rvSocialMedias)
        tvName = findViewById(R.id.tvName)
        ivProfilePic = findViewById(R.id.ivProfilePic)
        btnMessage = findViewById(R.id.btnMessage)
    }


    // recycler view adapter for the mutual friend image list
    inner class MutualFriendAdapter(var mutualFriendProfilePics: List<String>) :
        RecyclerView.Adapter<MutualFriendAdapter.Holder>() {


        inner class Holder(view: View) : RecyclerView.ViewHolder(view)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
            LayoutInflater
                .from(activity)
                .inflate(
                    R.layout.list_item_image,
                    parent,
                    false
                )
        )


        override fun onBindViewHolder(holder: Holder, position: Int) {
            val imageView = holder.itemView.findViewById<ImageView>(R.id.ivProfilePic)
            imageView.load(mutualFriendProfilePics[position])
        }

        override fun getItemCount(): Int = mutualFriendProfilePics.size
    }
}
