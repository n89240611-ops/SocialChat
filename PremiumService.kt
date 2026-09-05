package com.socialchat.features

interface PremiumService {
    fun queryProducts(): List<PremiumPlan>
    fun purchase(plan: PremiumPlan)
    fun restorePurchases()
    fun currentState(): SubscriptionState
    fun entitlements(): PremiumEntitlements
}
