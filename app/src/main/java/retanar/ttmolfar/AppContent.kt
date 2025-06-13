package retanar.ttmolfar

import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import retanar.ttmolfar.nav.AppNavBar
import retanar.ttmolfar.nav.AppNavHost

@Composable
internal fun AppContent() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        bottomBar = {
            AppNavBar(
                openNavBarRoute = { route ->
                    navController.navigate(route)
                },
                currentDestination = backStackEntry?.destination,
            )
        },
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier
                .padding(innerPadding)
                // Fixes issues with imePadding and NavBar
                .consumeWindowInsets(innerPadding),
        )
    }
}
