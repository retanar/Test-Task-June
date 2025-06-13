package retanar.ttmolfar.theme

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val DarkBlue = Color(0xFF1D2339)
val LightBlue = Color(0xFF415871)
val SkyBlue = Color(0xFF6ABED0)
val Gray = Color(0xFF8A8E9A)
val SmokeWhite = Color(0xFFF6F9FA)
val ShadowBlack = Color(0x08000000)
val LightSkyBlue = Color(0xFFE1F3F8)

val AppColorScheme = lightColorScheme(
    primary = DarkBlue,
    onPrimary = Color.White,
    secondary = LightBlue,
    tertiary = SkyBlue,
    primaryContainer = Color.White,
    onPrimaryContainer = DarkBlue,
    secondaryContainer = SmokeWhite,
    onSecondaryContainer = Gray,
    tertiaryContainer = LightSkyBlue,
    surfaceTint = Color.Unspecified,
)
