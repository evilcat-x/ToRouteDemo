package app.evilcat.compose.navigation.toroutedemo.navigation.ext

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

inline fun <reified T : Parcelable> generateNullableNavTypeSerializer(): NavType<T?> =
    object : NavType<T?>(isNullableAllowed = true) {
        override fun put(bundle: Bundle, key: String, value: T?) {
            bundle.putParcelable(key, value)
        }

        override fun get(bundle: Bundle, key: String): T? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(key, T::class.java)
            } else {
                bundle.getParcelable(key)
            }

        /**
         * Serialize the value to an url encoded string.
         * following [serializeAsValue does not mention that strings need to be Uri encoded](https://issuetracker.google.com/issues/344943214)
         * following NavType.StringType.serializeAsValue implementation
         * https://cs.android.com/androidx/platform/frameworks/support/+/androidx-main:navigation/navigation-common/src/main/java/androidx/navigation/NavType.kt;l=833
         */
        override fun serializeAsValue(value: T?): String =
            value?.let { Uri.encode(Json.encodeToString(value)) } ?: "null"

        override fun parseValue(value: String): T? = if (value == "null") {
            null
        } else {
            Json.decodeFromString<T>(value)
        }
    }
