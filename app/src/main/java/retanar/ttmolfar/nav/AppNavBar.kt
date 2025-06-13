package retanar.ttmolfar.nav

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import retanar.ttmolfar.R

@Composable
internal fun AppNavBar(
    openNavBarRoute: (route: String) -> Unit,
    currentDestination: NavDestination?,
) {
    // Hide navbar when not at top level
    if (NavBarItems.entries.none { currentDestination?.route == it.topRoute }) return

    NavigationBar {
        NavBarItems.entries.forEach { item ->
            val isSelected = currentDestination?.hierarchy
                ?.any { it.route == item.topRoute }
                ?: false

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (item.topRoute != ROUTE_PLACEHOLDER) {
                        openNavBarRoute(item.topRoute)
                    }
                },
                icon = { Icon(painterResource(item.icon), null) },
                label = { Text(item.title) },
            )
        }
    }
}

private const val ROUTE_PLACEHOLDER = "null"

enum class NavBarItems(val title: String, @DrawableRes val icon: Int, val topRoute: String) {
    Subliminals("Subliminals", R.drawable.headphones, Routes.Subliminals.ROUTE),
    Favorites("Favorites", R.drawable.heart, ROUTE_PLACEHOLDER),
    Journal("Journal", R.drawable.notes, ROUTE_PLACEHOLDER),
}
