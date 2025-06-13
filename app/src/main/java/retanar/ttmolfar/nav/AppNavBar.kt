package retanar.ttmolfar.nav

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import retanar.ttmolfar.R
import retanar.ttmolfar.util.showComingSoonToast

@Composable
internal fun AppNavBar(
    openNavBarRoute: (route: String) -> Unit,
    currentDestination: NavDestination?,
) {
    // Hide navbar when not at top level
    if (NavBarItems.entries.none { currentDestination?.route == it.topRoute }) return

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        NavBarItems.entries.forEach { item ->
            val context = LocalContext.current
            val isSelected = currentDestination?.hierarchy
                ?.any { it.route == item.topRoute }
                ?: false

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (item.topRoute != ROUTE_PLACEHOLDER) {
                        openNavBarRoute(item.topRoute)
                    } else {
                        context.showComingSoonToast()
                    }
                },
                icon = { Icon(painterResource(item.icon), null) },
                label = { Text(item.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.tertiary,
                    selectedTextColor = MaterialTheme.colorScheme.tertiary,
                    unselectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = Color.Transparent
                )
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
