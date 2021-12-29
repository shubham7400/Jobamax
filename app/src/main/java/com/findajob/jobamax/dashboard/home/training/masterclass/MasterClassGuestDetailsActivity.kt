package com.findajob.jobamax.dashboard.home.training.masterclass

import android.R.attr
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import com.findajob.jobamax.dashboard.home.training.masterclass.model.Guest
import com.findajob.jobamax.databinding.ActivityMasterClassGuestDetailsBinding

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import com.findajob.jobamax.R
import android.R.attr.right

import android.R.attr.left
import android.view.ViewGroup
import android.widget.LinearLayout





class MasterClassGuestDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMasterClassGuestDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMasterClassGuestDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureUi()
    }

    private fun configureUi() {
         val guest = intent.getSerializableExtra("guest") as Guest
        binding.guest = guest
        binding.llGuestLink.removeAllViews()
        for (index in guest.links?.indices!!){
            val textView = TextView(this).apply {
                setLinkTextColor(ContextCompat.getColor(context, R.color.white))
                textSize = 18F
                val params: LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                params.setMargins(0, 0, 0, 5)
                layoutParams = params
                text = Html.fromHtml("<a href=\"" +guest.links[index].link+ "\">" +guest.links[index].title+ "</a>")
                isClickable = true
                movementMethod = LinkMovementMethod.getInstance()
            }
            binding.llGuestLink.addView(textView)
        }
    }
}