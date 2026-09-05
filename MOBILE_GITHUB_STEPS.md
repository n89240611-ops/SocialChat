# Mobile-only GitHub build

1. Create/open your GitHub repository.
2. Upload the contents of this ZIP to the repository root.
3. Make sure `settings.gradle.kts`, `build.gradle.kts` and the `app` folder are directly in the repository root.
4. Open GitHub -> Actions.
5. Select **Build Social Chat APK**.
6. Tap **Run workflow**.
7. Wait for the green check.
8. Open the completed workflow run -> Artifacts.
9. Download `social-chat-debug-apk`.
10. Extract the ZIP and install `app-debug.apk` on Android.

The workflow builds `:app` directly. It does NOT look for `Chat/app`, which fixes the error:
`Chat/app does not exist, can't be written to or is not a directory.`
