package com.findajob.jobamax.data.pojo

data class Categories(val text: String, var isSelected: Boolean) {
    companion object {
        fun getJobCategories(): ArrayList<Categories> {
            return arrayListOf(
                Categories(
                    text = "Transportation and Material Moving Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Sales and Related Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Office and Administrative Support Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Healthcare Practitioners and Technical Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Management Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Food Preparation and Serving Related Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Computer and Mathematical Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Business and Financial Operations Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Healthcare Support Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Installation, Maintenance, and Repair Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Production Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Educational Instruction and Library Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Personal Care and Service Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Architecture and Engineering Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Community and Social Service Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Construction and Extraction Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Arts, Design, Entertainment, Sports, and Media Occupations ",
                    isSelected = false
                ),
                Categories(
                    text = "Life, Physical, and Social Science Occupations",
                    isSelected = false
                ),
                Categories(
                    text = "Building and Grounds Cleaning and Maintenance Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Protective Service Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Legal Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Farming, Fishing, and Forestry Occupations",
                    isSelected = false
                ),
                Categories  (
                    text = "Military Specific Occupations",
                    isSelected = false
                ),
            )
        }
    }

}
data class CategoryGroup(val list: ArrayList<Categories>)
