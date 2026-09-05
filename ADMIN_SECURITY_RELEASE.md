# Social Chat — Step 8
Admin, security and release preparation.

## Admin
Recommended admin capabilities:
- User search and account moderation
- Block/suspend/restore account
- Review reports
- Remove abusive content
- Basic app metrics
- Premium/subscription status review

Admin access must be enforced server-side with custom claims/roles. Never rely only on a hidden Android screen.

## Security checklist
- Firebase/Firestore rules deny unauthorized reads/writes.
- Users can edit only their own profile.
- Chat participants can access only conversations they belong to.
- Reports are writable by authenticated users but protected from arbitrary modification.
- Premium entitlements are verified server-side.
- Do not ship private service-account keys in the APK.
- Use test AdMob IDs during development.
- Validate all user-generated content and rate-limit abuse-prone operations.

## Release
1. Connect the Firebase project and add google-services.json.
2. Configure AdMob IDs.
3. Configure Google Play subscriptions.
4. Test authentication, chat, blocking/reporting and notifications.
5. Run a release build in Android Studio.
6. Sign the release with your own upload/release key.
7. Test the signed APK/AAB on a real device.
8. Publish through Google Play Console.

## Important
This package is source/release preparation. A real signed APK/AAB cannot be produced or published without the developer's Android signing key, Firebase configuration, AdMob account and Google Play Console access.
