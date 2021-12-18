package com.findajob.jobamax.dashboard.home.training.masterclass.model

import android.os.Parcelable
import com.findajob.jobamax.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MasterClass(
    val id: Int,
    val title: String,
    val image: Int
):Parcelable {
    companion object {
        fun generateMockData(): List<MasterClass> {
            return listOf(
                MasterClass(
                    id = 0,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                ),
                MasterClass(
                    id = 1,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                ),
                MasterClass(
                    id = 2,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                ),
                MasterClass(
                    id = 3,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                ),
                MasterClass(
                    id = 4,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                ),
                MasterClass(
                    id = 5,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                ),
                MasterClass(
                    id = 6,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                ),
                MasterClass(
                    id = 7,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                ),
                MasterClass(
                    id = 8,
                    title = "Master Class one",
                    image = R.drawable.img_master_class
                )
            )
        }
    }
}