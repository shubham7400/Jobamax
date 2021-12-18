package com.findajob.jobamax.recruiter.profile.subscription.adapter

import android.content.Context
import android.graphics.Typeface
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.databinding.ItemSubscriptionDetailsBinding
import com.findajob.jobamax.recruiter.profile.subscription.model.Subscription
import com.findajob.jobamax.util.*
import kotlin.properties.Delegates

class SubscriptionDetailsAdapter : RecyclerView.Adapter<SubscriptionDetailsAdapter.Holder>(),
    AutoUpdatableAdapter {

    internal var collection: List<Subscription> by Delegates.observable(emptyList()) { _, old, new ->
        autoNotify(old, new) { o, n -> o.hashCode() == n.hashCode() }
    }

    internal var clickListener: (Subscription, Boolean) -> Unit = { _, _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder.from(
        parent,
    )

    var isMonthly = true

    private lateinit var context: Context

    override fun getItemCount() = collection.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            context = root.context

            val subscriptionDetail = collection[position]

            item = subscriptionDetail

            buttonLabel = buttonLabel(subscriptionDetail.plan)

            val adapter = OfferAdapter()
            adapter.collection = subscriptionDetail.offer
            rvOffer.adapter = adapter
            offers = offersValue(subscriptionDetail.offer)

            subscriptionPrice = subscriptionPrice(subscriptionDetail)

            btnSubmit.setOnClickListener {
                clickListener(subscriptionDetail, isMonthly)
            }

            executePendingBindings()
        }
    }

    private fun subscriptionPrice(subscription: Subscription): CharSequence {
        return when (subscription.plan) {
            RECRUITER_STARTER_PLAN, RECRUITER_ENTERPRISE_PLAN -> {
                subscription.price
            }
            else -> {
                val price = subscription.price
                val month = " / ${context.getString(R.string.month)}"
                val priceAnnually = " ${subscription.priceAnnually}"
                val sb = StringBuilder()
                sb.append(price)
                if (!isMonthly) {
                    sb.append(priceAnnually)
                }
                sb.append(month)
                val spannableString = SpannableString(sb)
                if (!isMonthly) {
                    spannableString.strikeThrough(price)
                }
                spannableString.setColor(context, month, R.color.gray)
                spannableString.setSize(14, month)
                spannableString.setTypeFace(Typeface.NORMAL, month)
                spannableString
            }
        }
    }

    private fun buttonLabel(plan: String): String {
        return when (plan) {
            RECRUITER_STARTER_PLAN -> {
                context.getString(R.string.choose_plan)
            }
            RECRUITER_ENTERPRISE_PLAN -> {
                context.getString(R.string.contact)
            }
            else -> {
                context.getString(R.string._14_days_trial)
            }
        }
    }

    private fun offersValue(offers: List<String>): CharSequence {
        val stringBuilder = SpannableStringBuilder()
        offers.forEach {
            val spannableString = SpannableString("• $it\n")
            spannableString.setColor(context, "•", R.color.orange)
            stringBuilder.append(spannableString)
        }
        return stringBuilder
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    class Holder(val binding: ItemSubscriptionDetailsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): Holder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemSubscriptionDetailsBinding.inflate(inflater, parent, false)
                return Holder(binding)
            }
        }
    }
}
