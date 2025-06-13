package xyz.flymadison.runwaywx.data.models

import kotlinx.serialization.Serializable

/**
 * Represents visibility information, which can be either an integer value (typically in meters or statute miles)
 * or a string value (e.g., "CAVOK", "P6SM").
 *
 * This sealed class is used to model the polymorphic nature of visibility data often found in aviation weather reports.
 *
 * @see IntegerValue For visibility represented as a numerical value.
 * @see StringValue For visibility represented as a textual code or description.
 */
@Serializable
sealed class Visibility {
    class IntegerValue(val value: Long)  : Visibility()
    class StringValue(val value: String) : Visibility()
}

