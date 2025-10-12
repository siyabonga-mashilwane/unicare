package com.example.unicare.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// --- UniCare OneLight Color Palette ---

// Primary (Top bar, icons, accents)
val UniCarePrimary = Color(0xFF000000)        // Jet black
val UniCareOnPrimary = Color(0xFFFFFFFF)      // White text/icons on black

// Secondary / accents
val UniCareSecondary = Color(0xFF424242)      // Dark gray for subtle elements

// Backgrounds
val UniCareBackground = Color(0xFFE5E5E5)     // Light gray background (like screenshot)
val UniCareSurface = Color(0xFFFFFFFF)        // Pure white cards/search bars
val UniCareSurfaceVariant = Color(0xFFF5F5F5) // Slightly gray-tinted white for depth

// Text
val UniCareOnSurface = Color(0xFF212121)          // Deep neutral black text
val UniCareOnSurfaceVariant = Color(0xFF757575)   // Medium gray for placeholders/subtext

// Error
val UniCareError = Color(0xFFB00020)

private val OneLightColorScheme = lightColorScheme(
    primary = UniCarePrimary,
    onPrimary = UniCareOnPrimary,
    secondary = UniCareSecondary,
    background = UniCareBackground,
    surface = UniCareSurface,
    surfaceVariant = UniCareSurfaceVariant,
    onSurface = UniCareOnSurface,
    onSurfaceVariant = UniCareOnSurfaceVariant,
    error = UniCareError
)

@Composable
fun UniCareTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = OneLightColorScheme,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}



