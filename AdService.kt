package com.socialchat.features

interface AdService {
    fun loadBanner(slot: AdSlot)
    fun showInterstitial()
    fun destroy()
}
