# Android Module Structure – `com.example.unicare`

This structure follows a clean and scalable architecture for organizing Android-specific code in a Kotlin Multiplatform project.

## Package Overview

```
com.example.unicare/
├── components/
├── navigation/
├── screens/
├── utils/
├── viewModels/
├── MainActivity.kt
└── ReadMe.md
```

### `components/`
Contains **reusable UI elements** such as custom buttons, cards, or composables. These are modular and can be used across multiple screens.

> Example: `CustomButton.kt`, `ProfileCard.kt`

---

### `navigation/`
Holds **navigation logic**, such as route definitions or navigation graphs. Useful when using Jetpack Navigation or Compose Navigation.

> Example: `AppNavigator.kt`, `NavGraph.kt`

---

### `screens/`
Includes **screen-level UI code**, typically organized by feature or page. Each screen may have its own composables and interact with a ViewModel.

> Example: `LoginScreen.kt`, `DashboardScreen.kt`

---

### `utils/`
Stores **utility functions**, extensions, or helper classes that are used across the app.

> Example: `DateFormatter.kt`, `NetworkUtils.kt`

---

### `viewModels/`
Contains **ViewModel classes** that manage UI state and business logic for each screen, following the MVVM architecture.  
[**View Model Explanation**](https://developer.android.com/topic/libraries/architecture/viewmodel)  
 
> Example: `LoginViewModel.kt`, `DashboardViewModel.kt`

---

### `MainActivity.kt`
The **main entry point** of the Android application. It typically sets up the UI and initializes navigation or Compose content.

---

