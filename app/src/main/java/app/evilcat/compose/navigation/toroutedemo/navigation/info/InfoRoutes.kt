package app.evilcat.compose.navigation.toroutedemo.navigation.info

import android.os.Parcelable
import app.evilcat.compose.navigation.toroutedemo.navigation.ext.generateNullableNavTypeSerializer
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
sealed class InfoRoutes : Parcelable {
    @Serializable
    data object Main : InfoRoutes()

    @Serializable
    data object Legal : InfoRoutes()

    @Serializable
    data object Support : InfoRoutes()

    @Serializable
    data object LiveChat : InfoRoutes()

    companion object {
        val navTypeSerializer = generateNullableNavTypeSerializer<InfoRoutes>()
    }
}
