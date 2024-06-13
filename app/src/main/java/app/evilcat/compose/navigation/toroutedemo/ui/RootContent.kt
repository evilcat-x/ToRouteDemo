package app.evilcat.compose.navigation.toroutedemo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.evilcat.compose.navigation.toroutedemo.navigation.RootNavHost
import app.evilcat.compose.navigation.toroutedemo.ui.component.BottomNavigationBar
import app.evilcat.compose.navigation.toroutedemo.ui.theme.ToRouteDemoTheme

@Composable
fun RootContent() {
    ToRouteDemoTheme {
        val rootNavController = rememberNavController()
        val backStackEntry by rootNavController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomNavigationBar(
                    currentRoute = currentRoute,
                    rootNavController = rootNavController,
                )
            },
        ) { innerPadding ->
            RootNavHost(
                modifier = Modifier.padding(innerPadding),
                rootNavController = rootNavController,
            )
        }
    }
}
