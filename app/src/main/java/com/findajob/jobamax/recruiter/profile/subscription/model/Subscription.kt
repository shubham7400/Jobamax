package com.findajob.jobamax.recruiter.profile.subscription.model

data class Subscription(
    val name: String,
    val desc: String,
    val price: String,
    val priceAnnually: String,
    val offerHeader: String,
    val offer: List<String>,
    val plan: String,
) {
    companion object {
        fun generateMockData(): List<Subscription> {
            return listOf(
                Subscription(
                    plan = "starter",
                    name = "Starter",
                    desc = "For individual recruiters with occasional hiring needs",
                    price = "Free",
                    priceAnnually = "",
                    offerHeader = "Find your talent",
                    offer = listOf(
                        "1 AI sourcing contact credit per day.",
                        "Unlimited access to Jobamax Club",
                    )
                ),
                Subscription(
                    plan = "standard",
                    name = "Standard",
                    desc = "For individual recruiters with occasional hiring needs",
                    price = "$99",
                    priceAnnually = "$79",
                    offerHeader = "Find your talent",
                    offer = listOf(
                        "1 job listing per month",
                        "50 matches per month",
                        "50  AI sourcing contact credit per month",
                        "Unlimited access to Jobamax Club"
                    )
                ),
                Subscription(
                    plan = "premium",
                    name = "Premium",
                    desc = "For recruiters with continuous recruitment needs",
                    price = "$249",
                    priceAnnually = "$199",
                    offerHeader = "Boost your hiring needs",
                    offer = listOf(
                        "2-3 job listings per month",
                        "300 matches per month",
                        "Go back to a profile",
                        "150 AI sourcing contact credit per month",
                        "Unlimited access to Jobamax Club"
                    ),
                ),
                Subscription(
                    plan = "enterprise",
                    name = "Enterprise",
                    desc = "For recruiting team with advanced features needs",
                    price = "Custom plan",
                    priceAnnually = "",
                    offerHeader = "Boost your hiring needs",
                    offer = listOf(
                        "Number of job listings per month",
                        "Unlimited matches per month",
                        "Go back to a profile",
                        "Number of AI sourcing contact credit per month",
                        "Unlimited access to Jobamax Club"
                    )
                ),
            )
        }
    }
}