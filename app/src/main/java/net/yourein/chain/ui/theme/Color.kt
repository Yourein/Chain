package net.yourein.chain.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val ChainPrimary = Color(0xFF78D6E5)
val ChainSecondary = Color(0xFF3AB2F2)
val ChainTextPrimary = Color(0xFF4C4C4C)
val ChainWhite = Color(0xFFFFFFFF)
val ChainBackgroundPrimary = Color(0xFFFDFDFF)

val ChainGradiantIndicator = Brush.linearGradient(
    0.4f to Color(0xFFF23971),
    0.8f to Color(0xFFF48A83),
    start = Offset(0f, 0f),
    end = Offset(
        Float.POSITIVE_INFINITY,
        Float.POSITIVE_INFINITY
    )
)