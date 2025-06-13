package retanar.ttmolfar.util

import android.graphics.BlurMaskFilter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import retanar.ttmolfar.theme.ShadowBlack

fun Modifier.dropShadow(
    shape: Shape,
    color: Color = ShadowBlack,
    blur: Dp = 10.dp,
    offsetY: Dp = 10.dp,
    offsetX: Dp = 0.dp,
    spread: Dp = 0.dp,
) = drawBehind {
    val shadowSize = Size(size.width - blur.toPx(), size.height + spread.toPx())
    val shadowOutline = shape.createOutline(shadowSize, layoutDirection, this)
    val paint = Paint()
    paint.color = color

    if (blur.toPx() > 0) {
        paint.asFrameworkPaint().apply {
            maskFilter = BlurMaskFilter(blur.toPx(), BlurMaskFilter.Blur.NORMAL)
        }
    }

    drawIntoCanvas { canvas ->
        canvas.save()
        canvas.translate(offsetX.toPx() + (blur.toPx() / 2), offsetY.toPx())

        canvas.drawOutline(shadowOutline, paint)
        canvas.restore()
    }
}
