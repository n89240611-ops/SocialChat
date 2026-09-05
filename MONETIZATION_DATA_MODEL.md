# Monetization data model

Suggested Firestore collection:

users/{uid}
- subscriptionState
- subscriptionProductId
- subscriptionUpdatedAt

Suggested server-controlled fields:
- verifiedSubscription
- entitlementVersion

Do not trust a client-only premium flag for paid access. Verify purchases through Google Play/server-side infrastructure before granting permanent entitlements.
