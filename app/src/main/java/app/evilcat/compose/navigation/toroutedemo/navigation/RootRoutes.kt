package app.evilcat.compose.navigation.toroutedemo.navigation

import app.evilcat.compose.navigation.toroutedemo.navigation.info.InfoRoutes
import kotlinx.serialization.Serializable

sealed class RootRoutes {
    @Serializable
    data object Root : RootRoutes()

    @Serializable
    data object Home : RootRoutes()

    @Serializable
    data class Info(val targetDestination: InfoRoutes? = null) : RootRoutes()
}
