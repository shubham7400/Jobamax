package com.findajob.jobamax.data.pojo

import com.findajob.jobamax.R

data class CompanyProfile(
    val icon: Int?,
    val companyName: String,
    val info: List<CompanyInformationTest>?
)

data class CompanyInformationTest (
    val icon: Int,
    val description: String
) {
    companion object {

        fun generateMockCompanyInformation(): List<CompanyInformationTest> {
            return listOf(
                CompanyInformationTest(
                        icon = R.drawable.ic_recruiter,
                        description = "Company Name"
                ),
                CompanyInformationTest(
                        icon = R.drawable.ic_recruiter,
                        description = "Account"
                ),
                CompanyInformationTest(
                        icon = R.drawable.ic_recruiter,
                        description = "CV"
                ),
                CompanyInformationTest(
                        icon = R.drawable.ic_recruiter,
                        description = "Media"
                ),
            )
        }
    }
}
