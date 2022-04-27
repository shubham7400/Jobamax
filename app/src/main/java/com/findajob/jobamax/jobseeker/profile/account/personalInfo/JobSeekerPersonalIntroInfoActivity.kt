package com.findajob.jobamax.jobseeker.profile.account.personalInfo

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
 import android.view.View
import android.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.findajob.jobamax.MainActivity
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityJobSeekerPersonalIntroInfoBinding
 import com.findajob.jobamax.dialog.multiChoice.BasicDialog
import com.findajob.jobamax.enums.FirebaseDynamicLinkPath
import com.findajob.jobamax.enums.LoginType
import com.findajob.jobamax.enums.ParseTableFields
import com.findajob.jobamax.enums.ParseTableName
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeActivity
 import com.findajob.jobamax.model.JobSeeker
import com.findajob.jobamax.model.UserTempInfo
import com.findajob.jobamax.preference.*
import com.findajob.jobamax.util.*
  import com.google.firebase.dynamiclinks.ktx.androidParameters
import com.google.firebase.dynamiclinks.ktx.dynamicLink
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase
import com.parse.*
import kotlinx.android.synthetic.main.fragment_job_seeker_personal_information.*
import java.io.Serializable
import java.util.*
import kotlin.collections.HashMap




class JobSeekerPersonalIntroInfoActivity : BaseActivityMain<ActivityJobSeekerPersonalIntroInfoBinding>(), JobSeekerPersonalIntroInfoInterface {

    private lateinit var viewModel: JobSeekerPersonalIntroInfoViewModel
    private lateinit var personalInfoModel: JobSeekerPersonalInformationModel

    var user : UserTempInfo? = null


    override val layoutRes: Int get() = R.layout.activity_job_seeker_personal_intro_info

    override fun getViewModel(): ViewModel = viewModel

    override fun onCreated(instance: Bundle?) {
        configureViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        user = intent.getSerializableExtra(ARG_USER) as UserTempInfo
        initViews()
    }

    private fun initViews() {
        binding.handler = this
        binding.etEmailField.setText(user?.email ?: "")
        when(user?.loginType){
            LoginType.EMAIL.type -> {
                binding.etEmailField.isClickable = false
            }
            LoginType.FACEBOOK.type -> {
                binding.etEmailField.isClickable = true
            }
            LoginType.LINKEDIN.type -> {
                binding.etEmailField.isClickable = true
            }
            LoginType.GOOGLE.type -> {
                binding.etEmailField.isClickable = true
            }
        }

    }

    private fun configureViewModel() {
        viewModel = ViewModelProvider(this).get(JobSeekerPersonalIntroInfoViewModel::class.java)
        personalInfoModel = JobSeekerPersonalInformationModel()
    }



    override fun onGenderClicked(view: View) {

        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_gender, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.maleItem -> {
                    personalInfoModel.gender = "male"
                }
                R.id.femaleItem -> {
                    personalInfoModel.gender = "female"
                }
                else -> personalInfoModel.gender = "other"
            }
            binding.tvGenderHint.text = personalInfoModel.gender.capitalize(Locale.ROOT)
            true
        }
        popupMenu.show()
    }

    override fun onSubmitClicked() {
        addPhoneNumber()
        if (user != null) {
            if (validateFields()) {
                storeUserInParse()
            }
        }
    }

    private fun addPhoneNumber() {
        personalInfoModel.phoneNumber = binding.ccp.selectedCountryCodeWithPlus + " " + binding.etPhoneNumber.text.toString()
    }

    private val datePickerListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->

            val calendar = Calendar.getInstance()
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DATE, dayOfMonth)

            binding.tvGenderHint.error = null
            if (Date().addYear(-18).yyyyMMdd() < calendar.time.yyyyMMdd()) {
                toast("Age should be 18+")
            } else {
                binding.tvDateOfBirthField.text = calendar.time.dd_MM_yy()
            }
        }

    override fun onDobClicked() {
        val (year, month, day) = Triple(Date().year(), Date().month() - 1, Date().date() - 1)
        val datePickerDialog = DatePickerDialog(this, datePickerListener, year, month, day)
        datePickerDialog.show()
    }


    private fun validateFields(): Boolean {

        var validateFlag = true

        if (binding.tvGenderHint.text.isEmpty()) {
            binding.tvGenderHint.error = getString(R.string.enter_gender_here)
            validateFlag = false
        }

        if (binding.etFirstName.text.isEmpty()) {
            binding.etFirstName.error = getString(R.string.enter_first_name)
            validateFlag = false
        }

        if (binding.etEmailField.text.isEmpty()) {
            binding.etEmailField.error = getString(R.string.enter_email)
            validateFlag = false
        }
        if (!binding.etEmailField.text.toString().isValidEmail()){
            setEmail(binding.etEmailField.text.toString())
            toast("Enter valid email!")
            validateFlag = false
        }

        if (binding.tvDateOfBirthField.text.isEmpty()) {
            binding.tvDateOfBirthField.error = getString(R.string.enter_date_of_birth)
            validateFlag = false
        }

        if (binding.etPostalCode.text.isEmpty()) {
            binding.etPostalCode.error = getString(R.string.enter_postcode)
            validateFlag = false
        }

        if (binding.etPhoneNumber.text.isEmpty()) {
            binding.etPhoneNumber.error = getString(R.string.enter_phone_number)
            validateFlag = false
        } else if ((binding.etPhoneNumber.text.toString().trim().length + ccp.selectedCountryCodeWithPlus.length) <= 10) {
            toast(getString(R.string.enter_valid_phone_number))
             binding.etPhoneNumber.error = getString(R.string.enter_valid_phone_number)
            validateFlag = false
        }

        if (binding.etInvitationCode.text.isNotEmpty()){
            validatePromoCode()
        }

        return validateFlag
    }

    private fun validatePromoCode() {
        progressHud.show()
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.SalesPerson.toString())
        query.whereContains("promoCode", binding.etInvitationCode.toString())
        val result = query.find().firstOrNull()
        progressHud.dismiss()
        if (result == null){
            BasicDialog(this, "Invalid Promo Code!"){}.show()
        }else{
            storeUserInParse()
        }
    }

    private fun storeUserInParse() {
        progressHud.show()
        val jobSeeker = JobSeeker()
        val id = UUID.randomUUID().toString()
        jobSeeker.jobSeekerId = id
        jobSeeker.emailVerified = user?.loginType != LoginType.EMAIL.type
        jobSeeker.email = user!!.email
        jobSeeker.loginType = user!!.loginType
        jobSeeker.firstName = binding.etFirstName.text.toString()
        jobSeeker.lastName = binding.etLastName.text.toString()
        jobSeeker.gender = binding.tvGenderHint.text.toString()
        jobSeeker.postCode = binding.etPostalCode.text.toString()
        if (binding.etInvitationCode.text.isNotEmpty()){
            jobSeeker.totalReach = 10
        }
        jobSeeker.phoneNumber = binding.ccp.selectedCountryCode.toString()+binding.etPhoneNumber.text.toString()
        jobSeeker.dob = binding.tvDateOfBirthField.text.toString()
        jobSeeker.profilePicUrl = ""
        if (user!!.password != ""){
            jobSeeker.password = AESCrypt.encrypt(user!!.password)
        }
        jobSeeker.gotReferralCode = ""
        jobSeeker.accountType = 1
        jobSeeker.lat = getCurrentLatitude()
        jobSeeker.lng = getCurrentLongitude()
        jobSeeker.location = getAddressByLatLng(getCurrentLatitude(), getCurrentLongitude(), this)
        val parseObject = jobSeeker.toParseObject()
        parseObject.saveInBackground { e ->
            progressHud.dismiss()
            if (e != null) {
                toast(e.message.toString())
            } else {
                if (user!!.loginType == LoginType.EMAIL.type){
                    progressHud.show()
                    val builder = Uri.Builder()
                    builder.scheme("https")
                        .authority("jobamax.page.link")
                        .appendPath(FirebaseDynamicLinkPath.verifyemail.toString())
                        .appendQueryParameter("userType", getUserType().toString())
                        .appendQueryParameter("LoginType", LoginType.EMAIL.type)
                        .appendQueryParameter("recruiterId", id)
                    val myUrl: String = builder.build().toString()
                    val dynamicLink = Firebase.dynamicLinks.dynamicLink {
                        link = Uri.parse(myUrl)
                        domainUriPrefix = "https://jobamax.page.link"
                        androidParameters("com.findajob.jobamax") {
                        }
                    }
                    val param = HashMap<String, String>()
                    param["toEmail"] = getEmail()
                    param["link"] = dynamicLink.uri.toString()
                    ParseCloud.callFunctionInBackground<Any>("sendgridEmail", param) { obj, e ->
                        progressHud.dismiss()
                        if (e != null && obj == null) {
                            toast("Something Went Wrong.")
                        } else {
                            BasicDialog(
                                this@JobSeekerPersonalIntroInfoActivity,
                                "An email with verification link is sent to:\n ${getEmail()}",
                                true
                            ) {
                                startActivity(
                                    Intent(
                                        this@JobSeekerPersonalIntroInfoActivity,
                                        MainActivity::class.java
                                    )
                                )
                                finish()
                            }.also {
                                it.setCancelable(false)
                            }.show()
                        }
                    }
                }else{
                    getUserLogin(user!!)
                }
            }
        }
    }

    private fun getUserLogin(user: UserTempInfo) {
        log("dfsdjkl ${user.loginType}")
        progressHud.show()
        val query = ParseQuery.getQuery<ParseObject>(ParseTableName.JobSeeker.toString())
        query.whereEqualTo(ParseTableFields.email.toString(), user.email)
        if (user.loginType == LoginType.EMAIL.type){
            query.whereEqualTo(ParseTableFields.loginType.toString(), user.loginType)
            query.whereEqualTo(ParseTableFields.password.toString(), AESCrypt.encrypt(user.password))
        }
        query.getFirstInBackground { result, e ->
            progressHud.dismiss()
            if (e == null && result != null) {
                if (result.getBoolean("emailVerified")) {
                    val jobSeeker = JobSeeker(result)
                    setUserId(jobSeeker.jobSeekerId)
                    setPhoneNumber(jobSeeker.phoneNumber)
                    setLoginType(jobSeeker.loginType)
                    setLoggedIn(true)
                    if (checkForPermissions(permissions)) {
                        startActivity(Intent(this, JobSeekerHomeActivity::class.java))
                        finishAffinity()
                    }
                }else {
                    toast("Please verify account clicking on sent email at the time of registration.")
                }
            } else {
                toast("error: ${e.message.toString()}")
            }
        }
    }


    override fun onSkipped() {
        startActivity(Intent(this, JobSeekerHomeActivity::class.java))
        finish()
    }

    override fun onBackClicked() = super.onBackPressed()


}

interface JobSeekerPersonalIntroInfoInterface {

    fun onGenderClicked(view: View)

    fun onBackClicked()

    fun onSubmitClicked()

    fun onDobClicked()

    fun onSkipped()
}