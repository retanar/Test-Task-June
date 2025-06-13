package retanar.ttmolfar.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
internal fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Routes.Subliminals.ROUTE,
        modifier = modifier,
    ) {
        composable(route = Routes.Subliminals.ROUTE) {
        }

        composable(
            route = Routes.Details.ROUTE,
            arguments = Routes.Details.arguments
        ) { backStackEntry ->
            val title = backStackEntry.arguments?.getString(Routes.Details.ARG_TITLE).toString()
        }
    }
}

object Routes {
    object Subliminals {
        const val ROUTE = "subliminals"
    }

    object Details {
        const val ARG_TITLE = "title"
        const val ROUTE = "details/{$ARG_TITLE}"

        val arguments = listOf(
            navArgument(ARG_TITLE) { type = NavType.StringType },
        )

        fun constructRoute(title: String) = "details/$title"
    }
}
