package com.findajob.jobamax.recruiter.profile.account.invoices

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.findajob.jobamax.R
import com.findajob.jobamax.util.*
import com.parse.ParseObject
import kotlinx.android.synthetic.main.item_payment_history.view.*
import java.text.SimpleDateFormat

class PaymentHistoryAdapter(val onPaymentHistoryClicked: (paymentHistory: ParseObject) -> Unit) :
    RecyclerView.Adapter<PaymentHistoryAdapter.RecruiterHomeViewModel>() {

    private var paymentHistoryList: List<ParseObject> = listOf()

    fun notifyListChanged(paymentHistory: List<ParseObject>) {
        this.paymentHistoryList = paymentHistory
        notifyDataSetChanged()
    }

    inner class RecruiterHomeViewModel(view: View) : RecyclerView.ViewHolder(view) {

        fun bindTo(paymentHistory: ParseObject) {
            var title = ""
            var price = paymentHistory.get("amount")
            when (paymentHistory.getString("subscriptionId")) {
                RECRUITER_STANDARD_PLAN -> {
                    title = "Standard Professional"
                }
                RECRUITER_PREMIUM_PLAN -> {
                    title = "Premium Professional"
                }

                RECRUITER_ENTERPRISE_PLAN -> {
                    title = "Enterprise Experience"
                }

                RECRUITER_STARTER_PLAN -> {
                    title = "New User"
                }
            }

            val date = paymentHistory.createdAt
            val formatDate = SimpleDateFormat("MM/dd")
            val formatYear = SimpleDateFormat("yyy")
            itemView.plan_name.text = title
            itemView.price.text = "$$price"
            itemView.date.text = formatDate.format(date)
            itemView.year.text = formatYear.format(date)
            itemView.setOnClickListener {
                onPaymentHistoryClicked(paymentHistoryList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RecruiterHomeViewModel(parent.inflate(R.layout.item_payment_history))

    override fun onBindViewHolder(holder: RecruiterHomeViewModel, position: Int) =
        holder.bindTo(paymentHistoryList[position])

    override fun getItemCount(): Int = paymentHistoryList.size
}