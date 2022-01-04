package com.findajob.jobamax.dashboard.messages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.findajob.jobamax.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_chat)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        val messagesFragment = MessagesFragment()
        fragmentTransaction.add(R.id.fragment_container, messagesFragment, "HELLO")
        fragmentTransaction.commit()
    }
}