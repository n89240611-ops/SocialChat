# Firestore security checklist

Before production:
- Require authentication for private user data.
- Validate document ownership in security rules.
- Validate chat membership before message access.
- Prevent clients from assigning themselves admin roles.
- Keep admin role assignment server-controlled.
- Restrict writes to server-controlled subscription fields.
- Test rules with Firebase Emulator Suite.
