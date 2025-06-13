package retanar.ttmolfar.subliminals

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.PersistentList
import retanar.ttmolfar.R
import retanar.ttmolfar.theme.ShadowBlack
import retanar.ttmolfar.util.Dimens
import retanar.ttmolfar.util.showComingSoonToast

@Composable
fun SubliminalsScreen(onItemClick: (title: String) -> Unit) {
    val context = LocalContext.current

    // Not saveable
    val state = remember { ScreenState() }

    Box {
        BackgroundShapes()

        LazyColumn {
            item {
                Spacer(Modifier.windowInsetsPadding(WindowInsets.statusBars))
                Spacer(Modifier.height(Dimens.TopPadding))

                Row(modifier = Modifier.padding(horizontal = Dimens.ContentPadding)) {
                    AppIconButton(
                        iconRes = R.drawable.info,
                        onClick = { context.showComingSoonToast() }
                    )
                    Spacer(Modifier.weight(1f))
                    AppIconButton(
                        iconRes = R.drawable.search,
                        onClick = { context.showComingSoonToast() }
                    )
                }

                Spacer(Modifier.height(22.dp))

                Header(
                    chips = state.chips,
                    selectedChipIndex = state.selectedChipIndex,
                    selectChip = { state.selectedChipIndex = it })

                Spacer(Modifier.height(22.dp))
            }

            items(state.itemList) {
                SubliminalItem(it) { onItemClick(it.title) }
            }
        }
    }
}

@Composable
fun BackgroundShapes() {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.background_shape_top),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiaryContainer),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 7.dp)
        )

        Image(
            painter = painterResource(R.drawable.background_shape_bottom),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.tertiaryContainer),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(top = 316.dp)
        )
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
            .background(MaterialTheme.colorScheme.secondaryContainer, CircleShape)
            .size(Dimens.IconButtonSize)
    ) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(13.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
private fun Header(
    chips: PersistentList<String>,
    selectedChipIndex: Int,
    selectChip: (Int) -> Unit
) = Column(modifier = Modifier.fillMaxWidth()) {
    Text(
        text = "Good morning!",
        modifier = Modifier.padding(horizontal = Dimens.ContentPadding),
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary
    )

    Spacer(Modifier.height(2.dp))

    Text(
        text = "Your daily dose of subliminals is ready",
        modifier = Modifier.padding(horizontal = Dimens.ContentPadding),
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.secondary
    )

    Spacer(Modifier.height(19.dp))

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(Dimens.ChipSpacing),
        contentPadding = PaddingValues(horizontal = Dimens.ContentPadding)
    ) {
        itemsIndexed(chips) { i, title ->
            val (backgroundColor, textColor) = if (i == selectedChipIndex) {
                MaterialTheme.colorScheme.primary to MaterialTheme.colorScheme.onPrimary
            } else {
                MaterialTheme.colorScheme.secondaryContainer to MaterialTheme.colorScheme.onSecondaryContainer
            }

            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = textColor,
                modifier = Modifier
                    .background(backgroundColor, MaterialTheme.shapes.medium)
                    .clickable { selectChip(i) }
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
    Column(
        Modifier
            .padding(horizontal = Dimens.ContentPadding)
            .drawBehind {
                val offset = (91).dp.toPx()
                drawRect(
                    Brush.verticalGradient(
                        colors = listOf(ShadowBlack, Color.Transparent),
                    ),
                    topLeft = Offset(0f, offset)
                )
            }
    ) {
        Card(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.extraLarge,
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.SubliminalItemContentPadding)
            ) {
                Image(
                    imageVector = state.image,
                    contentDescription = null,
                    modifier = Modifier.size(Dimens.SubliminalItemImageSize),
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )

                Spacer(Modifier.width(Dimens.SubliminalItemContentSpacing))

                Column {
                    Text(
                        text = state.title, style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = state.description, style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
        }

        Spacer(Modifier.height(Dimens.SubliminalItemSpacing))
    }
}
