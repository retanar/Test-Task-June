package retanar.ttmolfar.subliminals

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList

@Stable
class ScreenState {
    private val itemCount = 10_000
    private val titles = persistentListOf(
        "Female Super Model Subliminal",
        "Greek God Physique Subliminal v5",
        "The most amazing subliminal for you",
        "Strongest Subliminal Booster v3",
    )
    private val icons = persistentListOf(
        Icons.Filled.AccountCircle,
        Icons.Filled.CheckCircle,
        Icons.Filled.Face,
        Icons.Filled.Favorite,
        Icons.Filled.Person,
        Icons.Filled.ThumbUp,
    )

    val itemList = List(itemCount) {
        SubliminalItemState(
            image = icons.random(),
            title = titles.random(),
            description = "Some description"
        )
    }.toPersistentList()

    val chips = listOf(
        "All together",
        "For women",
        "For men",
        "Health",
        "Something else"
    ).toPersistentList()
    var selectedChipIndex by mutableIntStateOf(0)
}

@Stable
data class SubliminalItemState(
    val image: ImageVector,
    val title: String,
    val description: String,
)
