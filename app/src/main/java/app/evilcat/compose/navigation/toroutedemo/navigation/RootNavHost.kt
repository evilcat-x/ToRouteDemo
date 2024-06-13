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
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("Home Screen")
                    Button(onClick = { rootNavController.navigate(RootRoutes.Info) }) {
                        Text("Go to Info")
                    }
                }
            }
            composable<RootRoutes.Info> {
                // Info screen
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text("Info Screen")
                    Button(onClick = { /*TODO*/ }) {
                        Text("Go to Info - Legal")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text("Go to Info - Support")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text("Go to Info - Live Chat")
                    }
                }
            }
        }
    }
}
