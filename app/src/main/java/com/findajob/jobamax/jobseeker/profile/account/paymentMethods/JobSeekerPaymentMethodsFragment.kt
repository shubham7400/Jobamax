package com.findajob.jobamax.jobseeker.profile.account.paymentMethods

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.findajob.jobamax.R
import com.findajob.jobamax.base.BaseFragmentMain
import com.findajob.jobamax.databinding.FragmentJobSeekerPaymentMethodsBinding
import com.findajob.jobamax.model.*
import com.findajob.jobamax.jobseeker.home.JobSeekerHomeViewModel
import com.findajob.jobamax.util.log
import com.findajob.jobamax.util.showBasicDialog
import com.stripe.android.PaymentConfiguration
import com.stripe.android.Stripe
import com.stripe.android.createPaymentMethod
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.jetbrains.anko.image

@AndroidEntryPoint
class JobSeekerPaymentMethodsFragment : BaseFragmentMain<FragmentJobSeekerPaymentMethodsBinding>(),
    JobSeekerPaymentMethodsInterface {

    val viewModel: JobSeekerHomeViewModel by activityViewModels()
    override fun getViewModel(): ViewModel {
        return viewModel
    }

    private lateinit var stripe: Stripe
    private var buttonClicked = false

    override fun editCard() {
        buttonClicked = true
        if (binding.cardInputWidget.visibility == VISIBLE) {
            // Collect card details on the client
            val cardInputWidget = binding.cardInputWidget
            val params = cardInputWidget.paymentMethodCreateParams ?: return

            stripe = Stripe(
                requireContext(),
                PaymentConfiguration.getInstance(requireContext()).publishableKey
            )
            lifecycleScope.launch {
                runCatching {
                    stripe.createPaymentMethod(params).id
                }.fold(
                    onSuccess = { paymentMethodId ->
                        viewModel.savePaymentMethod(
                            paymentMethodId!!,
                            object : SaveCardDetailsCallback {
                                override fun onSuccess(response: Any?) {
                                    showPaymentMethod()
                                }

                                override fun onFailure(e: Exception?) {
                                }
                            })
                    },
                    onFailure = {
                    }
                )
            }
        } else {
            viewModel.savePaymentMethod("", object : SaveCardDetailsCallback {
                override fun onSuccess(response: Any?) {
                    showPaymentMethod()
                }

                override fun onFailure(e: Exception?) {
                }
            })
        }
    }

    fun showPaymentMethod() {
        progressHud.show()

        viewModel.getCardDetails(object : GetCardDetailsCallback {
            override fun onSuccess(map: HashMap<String, Any>?) {
                val last4 = map?.get("last4").toString()
                val brand = map?.get("brand").toString()
                log(brand)
                binding.cardInputWidget.visibility = GONE
                binding.cardView.visibility = VISIBLE
                binding.cardDigits.text = "**** **** **** $last4"
                if (brand == "visa") {
                    binding.cardLogo.visibility = VISIBLE
                    binding.cardLogo.image = getDrawable(requireContext(), R.drawable.ic_visa)
                } else if (brand == "mastercard") {
                    binding.cardLogo.visibility = VISIBLE
                    binding.cardLogo.image = getDrawable(requireContext(), R.drawable.ic_mastercard)
                }

                binding.cardText.text = "Remove Card"
                binding.cardImage.image = getDrawable(requireContext(), R.drawable.ic_remove_circle)
                binding.cardInputWidget.clear()
                progressHud.dismiss()

                if (buttonClicked)
                    showBasicDialog(
                        requireContext(),
                        getString(R.string.add_card_successful),
                        null,
                        null
                    )
                buttonClicked = false
            }

            override fun onFailure(e: Exception?) {
                binding.cardInputWidget.visibility = VISIBLE
                binding.cardView.visibility = GONE
                binding.cardImage.image = getDrawable(requireContext(), R.drawable.ic_add_circle)

                binding.cardText.text = getString(R.string.add_new_card)
                progressHud.dismiss()

                if (buttonClicked)
                    showBasicDialog(
                        requireContext(),
                        getString(R.string.remove_card_successful),
                        null,
                        null
                    )
                buttonClicked = false
            }
        })

    }

    override fun onBackButtonClicked() {
        requireActivity().onBackPressed()
    }

    override val layoutRes: Int
        get() = R.layout.fragment_job_seeker_payment_methods

    override fun onCreated(savedInstance: Bundle?) {
        setHasOptionsMenu(true)
        binding.handler = this@JobSeekerPaymentMethodsFragment
        showPaymentMethod()
    }


}