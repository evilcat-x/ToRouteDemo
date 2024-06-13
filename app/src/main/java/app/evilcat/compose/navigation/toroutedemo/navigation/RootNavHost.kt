package app.evilcat.compose.navigation.toroutedemo.navigation

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import app.evilcat.compose.navigation.toroutedemo.navigation.info.InfoNavHost
import app.evilcat.compose.navigation.toroutedemo.navigation.info.InfoRoutes
import app.evilcat.compose.navigation.toroutedemo.ui.component.CenterColumn
import kotlin.reflect.typeOf

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
                    Button(onClick = {
                        rootNavController.navigate(RootRoutes.Info()) {
                            popUpTo(RootRoutes.Root) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }) {
                        Text("Go to Info - With Restore State")
                    }
                    Button(onClick = {
                        rootNavController.navigate(
                            RootRoutes.Info(
                                targetDestination = null,
                            ),
                        ) {
                            popUpTo(RootRoutes.Root) { saveState = true }
                            launchSingleTop = true
                        }
                    }) {
                        Text("Go to Info - No Restore State")
                    }
                    Button(onClick = {
                        rootNavController.navigate(
                            RootRoutes.Info(
                                targetDestination = InfoRoutes.Legal,
                            ),
                        ) {
                            popUpTo(RootRoutes.Root) { saveState = true }
                            launchSingleTop = true
                        }
                    }) {
                        Text("Go to Info - Legal")
                    }
                    Button(onClick = {
                        rootNavController.navigate(
                            RootRoutes.Info(
                                targetDestination = InfoRoutes.Support,
                            ),
                        ) {
                            popUpTo(RootRoutes.Root) { saveState = true }
                            launchSingleTop = true
                        }
                    }) {
                        Text("Go to Info - Support")
                    }
                    Button(onClick = {
                        rootNavController.navigate(
                            RootRoutes.Info(
                                targetDestination = InfoRoutes.LiveChat,
                            ),
                        ) {
                            popUpTo(RootRoutes.Root) { saveState = true }
                            launchSingleTop = true
                        }
                    }) {
                        Text("Go to Info - Live Chat")
                    }
                }
            }
            composable<RootRoutes.Info>(
                typeMap = mapOf(typeOf<InfoRoutes?>() to InfoRoutes.navTypeSerializer),
            ) { backStackEntry ->
                val (targetDestination) = backStackEntry.toRoute<RootRoutes.Info>()
                val currentLifecycleState = backStackEntry.lifecycle.currentState

                Log.d(
                    "RootNavHost",
                    "Current Lifecycle State is: $currentLifecycleState, targetDestination: $targetDestination",
                )
                // Info NavHost
                InfoNavHost(targetDestination = targetDestination)
            }
        }
    }
}
