package retanar.ttmolfar.subliminals

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import retanar.ttmolfar.R
import retanar.ttmolfar.util.Dimens

val itemList = List(10) {
    SubliminalItemState(R.drawable.ic_launcher_foreground, "Title $it", "Desc")
}

@Composable
fun SubliminalsScreen(onItemClick: (title: String) -> Unit) {
    LazyColumn {
        item {
            Spacer(Modifier.windowInsetsPadding(WindowInsets.statusBars))
            Spacer(Modifier.height(Dimens.TopPadding))

            Row(modifier = Modifier.padding(horizontal = Dimens.ContentPadding)) {
                AppIconButton(
                    iconRes = R.drawable.info,
                    onClick = {}
                )
                Spacer(Modifier.weight(1f))
                AppIconButton(
                    iconRes = R.drawable.search,
                    onClick = {}
                )
            }

            Spacer(Modifier.height(22.dp))

            Header()

            Spacer(Modifier.height(22.dp))
        }

        items(itemList) {
            SubliminalItem(it) { onItemClick(it.title) }
            Spacer(Modifier.height(Dimens.SubliminalItemSpacing))
        }
    }
}

@Composable
fun AppIconButton(
    @DrawableRes iconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .background(Color.Blue, CircleShape)
            .size(Dimens.IconButtonSize)
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(13.dp)
        )
    }
}

private val chips = listOf("All together", "For women", "For men", "Health", "Something else")

@Composable
private fun Header() = Column(modifier = Modifier.fillMaxWidth()) {
    Text(
        text = "Good morning!",
        modifier = Modifier.padding(horizontal = Dimens.ContentPadding)
    )

    Spacer(Modifier.height(2.dp))

    Text(
        text = "Your daily dose of subliminals is ready",
        modifier = Modifier.padding(horizontal = Dimens.ContentPadding)
    )

    Spacer(Modifier.height(19.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Dimens.ChipSpacing),
        contentPadding = PaddingValues(horizontal = Dimens.ContentPadding)
    ) {
        items(chips) { title ->
            Text(
                text = title,
                modifier = Modifier
                    .background(Color.Blue, MaterialTheme.shapes.medium)
                    .padding(
                        horizontal = Dimens.ChipPaddingHorizontal,
                        vertical = Dimens.ChipPaddingVertical
                    )
            )
        }
    }
}

@Composable
private fun SubliminalItem(state: SubliminalItemState, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.ContentPadding),
        shape = MaterialTheme.shapes.extraLarge,
        elevation = CardDefaults.cardElevation(
            defaultElevation = Dimens.ItemCardElevation,
            pressedElevation = Dimens.ItemCardElevationPressed,
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimens.SubliminalItemContentPadding)
        ) {
            Image(
                painter = painterResource(state.image),
                contentDescription = null,
                modifier = Modifier.size(Dimens.SubliminalItemImageSize)
            )

            Spacer(Modifier.width(Dimens.SubliminalItemContentSpacing))

            Column {
                Text(text = state.title)
                Spacer(Modifier.height(6.dp))
                Text(text = state.description)
            }
        }
    }
}

data class SubliminalItemState(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,
)
