package com.jobamax.appjobamax.jobseeker.profile.account.password

import android.os.Bundle
import android.view.MenuItem
import com.jobamax.appjobamax.BaseActivity
import com.jobamax.appjobamax.R
import com.jobamax.appjobamax.databinding.ActivityJobSeekerPasswordBinding
import com.jobamax.appjobamax.util.errorToast
import com.jobamax.appjobamax.util.toast
import com.parse.ParseUser

class JobSeekerPasswordActivity : BaseActivity(), JobSeekerPasswordInterface {

    lateinit var binding: ActivityJobSeekerPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJobSeekerPasswordBinding.inflate(layoutInflater)
        binding.handler = this
        setContentView(binding.root)
    }

    override fun onSubmitClicked() {
        if (binding.newPasswordField.text.isEmpty()) {
            binding.newPasswordField.error = getString(R.string.enter_new_password)
            return
        }

        if (binding.confirmNewPasswordField.text.isEmpty()) {
            binding.confirmNewPasswordField.error = getString(R.string.enter_new_password)
            return
        }

        val newPassword = binding.newPasswordField.text.toString()
        val confirmNewPassword = binding.confirmNewPasswordField.text.toString()

        if (newPassword != confirmNewPassword) {
            toast(getString(R.string.password_not_matching))
            return
        }

        if (newPassword.length < 7) {
            toast("Password should have at least 7 characters")
            return
        }

        changePassword(newPassword)
    }

    override fun onBackPress() {
        onBackPressed()
    }

    private fun changePassword(newPassword: String) {
        val currentUser = ParseUser.getCurrentUser()
        currentUser.setPassword(newPassword)
        progressHud.show()
        currentUser.saveInBackground {
            progressHud.dismiss()
            if (it == null) {
                toast(getString(R.string.password_updated))
                finish()
            } else errorToast(it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
}

/*
interface JobSeekerPasswordInterface {
    fun onSubmitClicked()
    fun onBackPress()
}*/
