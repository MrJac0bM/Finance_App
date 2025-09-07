import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp

@Preview
@Composable
fun CircularProgressBar(
    progress: Float = 0.7f, // porcentaje completado (0f a 1f)
    max: Float = 1f,
    color: Color = Color.Blue,
    backgroundColor: Color = Color.LightGray,
    stroke: Dp,
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val strokeWidth = 20f // puedes cambiar el grosor
        val sweepAngle = (progress / max) * 360f

        // Fondo completo
        drawArc(
            color = backgroundColor,
            startAngle = -90f,
            sweepAngle = (progress/max) * 360f,
            useCenter = false,
            style = Stroke(width = stroke.toPx(), cap = StrokeCap.Round)
        )

        drawArc(
            color = backgroundColor,
            startAngle = -90f,
            sweepAngle = 360f,
            useCenter = false,
            style = Stroke(width = stroke.toPx(), cap = StrokeCap.Round)
        )


    }
}
