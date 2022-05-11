package com.findajob.jobamax.data.pojo

import android.content.Context
import com.findajob.jobamax.R

data class Categories(val text: String, var isSelected: Boolean) {
    companion object {
        fun getJobCategories(context: Context): ArrayList<Categories> {
            return arrayListOf(
                Categories(
                    text = context.getString(R.string.job_search_category_row1),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row2),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row3),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row4),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row5),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row6),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row7),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row8),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row9),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row10),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row11),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row12),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row13),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row14),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row15),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row16),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row17),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row18),
                    isSelected = false
                ),
                Categories(
                    text = context.getString(R.string.job_search_category_row19),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row20),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row21),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row22),
                    isSelected = false
                ),
                Categories  (
                    text = context.getString(R.string.job_search_category_row23),
                    isSelected = false
                ),
            )
        }
    }

}
data class CategoryGroup(val list: ArrayList<Categories>)
