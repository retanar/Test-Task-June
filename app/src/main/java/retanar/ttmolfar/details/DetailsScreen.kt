package retanar.ttmolfar.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import retanar.ttmolfar.R
import retanar.ttmolfar.subliminals.AppIconButton
import retanar.ttmolfar.util.Dimens

@Composable
fun DetailsScreen(title: String, popBackStack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.systemBars),
    ) {
        AppIconButton(
            iconRes = R.drawable.arrow,
            onClick = popBackStack,
            modifier = Modifier.padding(top = Dimens.TopPadding, start = Dimens.ContentPadding)
        )

        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center
        )
    }
}
