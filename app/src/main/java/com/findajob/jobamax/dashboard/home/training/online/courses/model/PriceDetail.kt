package com.findajob.jobamax.dashboard.home.training.online.courses.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PriceDetail(val amount: Double, val currency: String, val currency_symbol: String, val price_string: String):Parcelable