package com.findajob.jobamax.dashboard.messages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivityMainChatBinding
import com.findajob.jobamax.databinding.ActivityMainChatBindingImpl
import com.findajob.jobamax.databinding.ItemChatUserHorizontalBinding
import com.findajob.jobamax.databinding.ItemChatUserVerticalBinding
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.userAgent

class MainChatActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

       configureUi()
    }

    private fun configureUi() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, ChatUserListFragment())
            .commit()
    }
}

