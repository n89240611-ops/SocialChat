package com.socialchat.features

object FeatureGate {
    fun canUsePremiumFeature(state: SubscriptionState): Boolean =
        state == SubscriptionState.ACTIVE
}
