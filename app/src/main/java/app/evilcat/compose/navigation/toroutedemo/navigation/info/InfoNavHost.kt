package app.evilcat.compose.navigation.toroutedemo.navigation.info

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.evilcat.compose.navigation.toroutedemo.ui.component.CenterColumn

@Composable
fun InfoNavHost(
    modifier: Modifier = Modifier,
    targetDestination: InfoRoutes? = null,
    infoNavController: NavHostController = rememberNavController(),
) {
    LaunchedEffect(targetDestination) {
        targetDestination?.let { infoNavController.navigate(it) }
    }

    NavHost(
        navController = infoNavController,
        startDestination = InfoRoutes.Main,
        modifier = modifier,
    ) {
        composable<InfoRoutes.Main> {
            CenterColumn {
                Text("Info Screen")
                Button(onClick = { infoNavController.navigate(InfoRoutes.Legal) }) {
                    Text("Go to Info - Legal")
                }
                Button(onClick = { infoNavController.navigate(InfoRoutes.Support) }) {
                    Text("Go to Info - Support")
                }
                Button(onClick = { infoNavController.navigate(InfoRoutes.LiveChat) }) {
                    Text("Go to Info - Live Chat")
                }
            }
        }
        composable<InfoRoutes.Legal> {
            CenterColumn {
                Text("Legal Screen")
                Button(onClick = { infoNavController.navigateUp() }) {
                    Text("Go Back")
                }
            }
        }
        composable<InfoRoutes.Support> {
            CenterColumn {
                Text("Support Screen")
                Button(onClick = { infoNavController.navigateUp() }) {
                    Text("Go Back")
                }
            }
        }
        composable<InfoRoutes.LiveChat> {
            CenterColumn {
                Text("Live Chat Screen")
                Button(onClick = { infoNavController.navigateUp() }) {
                    Text("Go Back")
                }
            }
        }
    }
}
