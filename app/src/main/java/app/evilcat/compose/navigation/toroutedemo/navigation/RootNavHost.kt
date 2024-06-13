package app.evilcat.compose.navigation.toroutedemo.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import app.evilcat.compose.navigation.toroutedemo.navigation.info.InfoNavHost
import app.evilcat.compose.navigation.toroutedemo.ui.component.CenterColumn

@Composable
fun RootNavHost(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController = rememberNavController(),
) {
    NavHost(
        modifier = modifier,
        navController = rootNavController,
        startDestination = RootRoutes.Root,
    ) {
        navigation<RootRoutes.Root>(startDestination = RootRoutes.Home) {
            composable<RootRoutes.Home> {
                // Home screen
                CenterColumn {
                    Text("Home Screen")
                    Button(onClick = { rootNavController.navigate(RootRoutes.Info) }) {
                        Text("Go to Info")
                    }
                }
            }
            composable<RootRoutes.Info> {
                // Info NavHost
                InfoNavHost()
            }
        }
    }
}
