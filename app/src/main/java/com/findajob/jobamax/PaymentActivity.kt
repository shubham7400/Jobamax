package com.findajob.jobamax

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.findajob.jobamax.base.BaseActivityMain
import com.findajob.jobamax.databinding.ActivityPaymentBinding
import com.findajob.jobamax.util.showBasicDialog
import com.parse.FunctionCallback
import com.parse.ParseCloud
import com.parse.ParseUser
import com.stripe.android.PaymentConfiguration
import com.stripe.android.Stripe
import com.stripe.android.getPaymentIntentResult
import com.stripe.android.model.ConfirmPaymentIntentParams
import com.stripe.android.model.PaymentIntent
import com.stripe.android.model.StripeIntent
import kotlinx.android.synthetic.main.activity_payment.*
import kotlinx.coroutines.launch
import org.jetbrains.anko.image


class PaymentActivity : BaseActivityMain<ActivityPaymentBinding>() {

    private lateinit var paymentIntentClientSecret: String
    private lateinit var stripe: Stripe
    private lateinit var plan: String
    private var isFreeTrial: Boolean = false
    private var isMonthly: Boolean = true
    private var hasSavedCard: Boolean = false
    private var price: String = ""

    override val layoutRes: Int
        get() = R.layout.activity_payment

    override fun getViewModel(): ViewModel? = null

    override fun onCreated(instance: Bundle?) {
        backButton.setOnClickListener {
            super.onBackPressed()
        }


        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        price = intent.getStringExtra("price").toString()
        isFreeTrial = intent.getBooleanExtra("isFreeTrial", false);
        isMonthly = intent.getBooleanExtra("isMonthly", true);
        plan = intent.getStringExtra("plan").toString()

        titleText.text = title
        descriptionText.text = description
        priceText.text = price

        if (!isFreeTrial) {
            payButton.text = getString(R.string.one_month_free_trial)
            isFreeTrial = true
            payButton.setOnClickListener {
                displayAlert(
                    getString(R.string.one_month_free_trial_started),
                    null,
                    success = true
                )
            }
        } else {
            val params = java.util.HashMap<String, Any>()
            params["userId"] = ParseUser.getCurrentUser().objectId
            stripe = Stripe(this, PaymentConfiguration.getInstance(applicationContext).publishableKey)
            ParseCloud.callFunctionInBackground("retrieveCard", params, FunctionCallback<java.util.HashMap<String, Any>?> { response, e ->
                    if (e == null) {
                        cardInputWidget.visibility = GONE
                        cardView.visibility = VISIBLE
                        val last4 = response?.get("last4").toString()
                        val brand = response?.get("brand").toString()
                        card_digits.text = "**** **** **** $last4"
                        if (brand == "visa") {
                            card_logo.visibility = VISIBLE
                            card_logo.image =
                                AppCompatResources.getDrawable(this, R.drawable.ic_visa)
                        } else if (brand == "mastercard") {
                            card_logo.visibility = VISIBLE
                            card_logo.image =
                                AppCompatResources.getDrawable(this, R.drawable.ic_mastercard)
                        }
                        hasSavedCard = true

                    } else {
                        startCheckout()
                        cardInputWidget.visibility = VISIBLE
                        cardView.visibility = GONE
                        Log.d("Cloud Response", "Exception: $e")
                    }
                })

            // Confirm the PaymentIntent with the card widget
            payButton.setOnClickListener {
                if (!hasSavedCard) {
                    cardInputWidget.paymentMethodCreateParams?.let { params ->
                        val confirmParams = ConfirmPaymentIntentParams
                            .createWithPaymentMethodCreateParams(params, paymentIntentClientSecret)

                        progressHud.show()
                        stripe.confirmPayment(this, confirmParams)
                    }
                } else {
                    progressHud.show()
                    startCheckout()
                }
            }
        }
    }


    private fun displayAlert(
        title: String,
        intent: PaymentIntent?,
        success: Boolean = false
    ) {
        runOnUiThread {
            if (success) {
                val onDismissListener = DialogInterface.OnDismissListener {
                    val data = Intent()
                    data.putExtra("plan", plan)
                    data.putExtra("price", price)
                    data.putExtra("isFreeTrial", isFreeTrial)
                    setResult(Activity.RESULT_OK, data)
                    finish()
                }
                showBasicDialog(this, title, null, onDismissListener)
            } else {
                showBasicDialog(this, title, null, null)
            }
        }
    }

    private fun startCheckout() {
        // Create a PaymentIntent by calling the sample server's /create-payment-intent endpoint.
        val params = HashMap<String, Any>()

        params["plan"] = plan
        params["userId"] = ParseUser.getCurrentUser().objectId

        ParseCloud.callFunctionInBackground(
            "purchasePlan",
            params,
            FunctionCallback<HashMap<String, String>?> { response, e ->
                if (e == null) {
                    progressHud.dismiss()
                    Log.d("Cloud Response", "There were no exceptions! $response")
                    paymentIntentClientSecret = response?.get("clientSecretId").toString()
                    if (hasSavedCard) {
                        displayAlert(
                            getString(R.string.payment_successful),
                            null,
                            success = true
                        )
                    }
                } else {
                    progressHud.dismiss()
                    Log.d("Cloud Response", "Exception: $e")
                    Toast.makeText(
                        applicationContext,
                        e.message,
                        Toast.LENGTH_LONG
                    ).show()
                    if (hasSavedCard) {
                        displayAlert(
                            getString(R.string.payment_failed),
                            null
                        )
                    }
                }
            })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Handle the result of stripe.confirmPayment
        if (stripe.isPaymentResult(requestCode, data)) {
            lifecycleScope.launch {
                runCatching {
                    stripe.getPaymentIntentResult(requestCode, data!!)
                }.fold(
                    onSuccess = { result ->
                        progressHud.dismiss()
                        val paymentIntent = result.intent
                        if (paymentIntent.status == StripeIntent.Status.Succeeded) {

                            displayAlert(
                                getString(R.string.payment_successful),
                                paymentIntent,
                                success = true
                            )
                        } else if (paymentIntent.status == StripeIntent.Status.RequiresPaymentMethod) {
                            displayAlert(
                                getString(R.string.payment_failed),
                                null
                            )
                        }
                    },
                    onFailure = {
                        progressHud.dismiss()
                        displayAlert(
                            getString(R.string.error),
                            null
                        )
                    }
                )
            }
        }
    }
}