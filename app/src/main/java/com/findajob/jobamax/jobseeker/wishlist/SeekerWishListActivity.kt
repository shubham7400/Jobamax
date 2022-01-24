package com.findajob.jobamax.jobseeker.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ActivitySeekerWishListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeekerWishListActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeekerWishListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekerWishListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureUi()
    }

    private fun configureUi() {
        setClickListeners()
    }

    private fun setClickListeners() {

    }
}