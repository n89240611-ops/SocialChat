package com.socialchat.features

enum class AdSlot { HOME_BANNER, CHAT_BANNER, DISCOVERY_NATIVE, INTERSTITIAL }

enum class PremiumPlan(val productId: String) {
    MONTHLY("socialchat_premium_monthly"),
    YEARLY("socialchat_premium_yearly")
}

enum class SubscriptionState {
    FREE, ACTIVE, EXPIRED, PENDING
}

data class MonetizationConfig(
    val adsEnabled: Boolean = true,
    val premiumEnabled: Boolean = true
)

data class PremiumEntitlements(
    val removeAds: Boolean = false,
    val premiumBadge: Boolean = false,
    val advancedDiscovery: Boolean = false
)
