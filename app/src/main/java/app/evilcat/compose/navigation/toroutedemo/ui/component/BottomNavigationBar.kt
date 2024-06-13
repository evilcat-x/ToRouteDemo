package app.evilcat.compose.navigation.toroutedemo.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import app.evilcat.compose.navigation.toroutedemo.navigation.RootRoutes

@Composable
fun BottomNavigationBar(currentRoute: String?, rootNavController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected =
            RootRoutes.Home::class.qualifiedName?.let {
                currentRoute?.startsWith(
                    it,
                )
            } == true,
            onClick = {
                rootNavController.navigate(RootRoutes.Home) {
                    popUpTo(RootRoutes.Root) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(Icons.Default.Home, "Home") },
        )
        NavigationBarItem(
            selected =
            RootRoutes.Info::class.qualifiedName?.let {
                currentRoute?.startsWith(
                    it,
                )
            } == true,
            onClick = {
                rootNavController.navigate(RootRoutes.Info) {
                    popUpTo(RootRoutes.Root) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
            icon = { Icon(Icons.Default.Info, "Info") },
        )
    }
}
