package app.evilcat.compose.navigation.toroutedemo.navigation

import kotlinx.serialization.Serializable

sealed class RootRoutes {
    @Serializable
    data object Root : RootRoutes()

    @Serializable
    data object Home : RootRoutes()

    @Serializable
    data object Info : RootRoutes()
}
