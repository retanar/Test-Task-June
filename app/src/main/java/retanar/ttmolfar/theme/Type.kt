package retanar.ttmolfar.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import retanar.ttmolfar.R

val Gilroy = FontFamily(
    Font(R.font.gilroy_thin, FontWeight.Thin),
    Font(R.font.gilroy_ultralight, FontWeight.ExtraLight),
    Font(R.font.gilroy_light, FontWeight.Light),
    Font(R.font.gilroy_regular, FontWeight.Normal),
    Font(R.font.gilroy_medium, FontWeight.Medium),
    Font(R.font.gilroy_semibold, FontWeight.SemiBold),
    Font(R.font.gilroy_bold, FontWeight.Bold),
    Font(R.font.gilroy_extrabold, FontWeight.ExtraBold),
    Font(R.font.gilroy_black, FontWeight.Black),
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.W700,
        fontSize = 34.sp,
        letterSpacing = (-0.68).sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        letterSpacing = (-0.28).sp
    ),

    titleLarge = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        letterSpacing = (-0.32).sp
    ),
    titleSmall = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        letterSpacing = (-0.24).sp
    ),

    labelLarge = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.W600,
        fontSize = 12.sp,
        letterSpacing = (-0.24).sp
    ),
    labelMedium = TextStyle(
        fontFamily = Gilroy,
        fontWeight = FontWeight.W500,
        fontSize = 10.sp,
        letterSpacing = (-0.24).sp
    )
)
