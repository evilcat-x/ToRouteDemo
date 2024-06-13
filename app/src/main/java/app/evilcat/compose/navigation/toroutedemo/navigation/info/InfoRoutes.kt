package app.evilcat.compose.navigation.toroutedemo.navigation.info

import kotlinx.serialization.Serializable

sealed class InfoRoutes {
    @Serializable
    data object Main : InfoRoutes()

    @Serializable
    data object Legal : InfoRoutes()

    @Serializable
    data object Support : InfoRoutes()

    @Serializable
    data object LiveChat : InfoRoutes()
}
