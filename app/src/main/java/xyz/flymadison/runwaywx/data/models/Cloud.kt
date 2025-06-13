package xyz.flymadison.runwaywx.data.models

import kotlinx.serialization.Serializable

/**
 * Represents cloud information for a weather report.
 *
 * @property cover The cloud cover type (e.g., "FEW", "SCT", "BKN", "OVC").
 * @property base The cloud base altitude in feet AGL (Above Ground Level), if available.
 */
@Serializable
data class Cloud (
    val cover: String,
    val base: Long? = null
)