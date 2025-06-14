package xyz.flymadison.runwaywx.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a weather station and its associated meteorological data.
 *
 * This data class is used to deserialize JSON responses from a weather API.
 * It contains various weather parameters observed at a specific station.
 *
 * @property metarID The unique identifier for the METAR report.
 * @property icaoID The ICAO identifier of the station (e.g., "KMSN").
 * @property receiptTime The time the report was received by the system.
 * @property obsTime The observation time in Unix epoch seconds.
 * @property reportTime The time the report was generated by the station.
 * @property temp The temperature in Celsius.
 * @property dewp The dew point temperature in Celsius.
 * @property wdir The wind direction in degrees.
 * @property wspd The wind speed in knots.
 * @property wgst The wind gust speed in knots, if applicable.
 * @property visib The visibility.
 * @property altim The altimeter setting in inches of Mercury (inHg).
 * @property slp The sea level pressure in millibars (hPa), if available.
 * @property qcField Quality control field information.
 * @property wxString A string describing current weather phenomena (e.g., "RA" for rain).
 * @property presTend Pressure tendency, if available.
 * @property maxT Maximum temperature observed in the last period, if available.
 * @property minT Minimum temperature observed in the last period, if available.
 * @property maxT24 Maximum temperature in the last 24 hours, if available.
 * @property minT24 Minimum temperature in the last 24 hours, if available.
 * @property precip Precipitation amount, if available.
 * @property pcp3Hr Precipitation amount in the last 3 hours, if available.
 * @property pcp6Hr Precipitation amount in the last 6 hours, if available.
 * @property pcp24Hr Precipitation amount in the last 24 hours, if available.
 * @property snow Snow depth, if available.
 * @property vertVis Vertical visibility in feet, if applicable (e.g., during fog).
 * @property metarType The type of METAR report (e.g., "METAR", "SPECI").
 * @property rawOb The raw METAR or SPECI observation data.
 * @property mostRecent The Unix epoch timestamp of the most recent observation.
 * @property lat The latitude of the station.
 * @property lon The longitude of the station.
 * @property elev The elevation of the station in feet.
 * @property prior The Unix epoch timestamp of the prior observation.
 * @property name The name of the station.
 * @property clouds A list of [Cloud] objects representing cloud cover information.
 */
@Serializable
data class Station (
    @SerialName("metar_id")
    val metarID: Long,

    @SerialName("icaoId")
    val icaoID: String,

    val receiptTime: String,
    val obsTime: Long,
    val reportTime: String,
    val temp: Double, // Temperature in Celsius
    val dewp: Double, // Dew point in Celsius
    @Serializable(with = VisibilitySerializer::class)
    val wdir: Float?, // Wind direction in degrees. Null if variable/calm.
    val wspd: Long,   // Wind speed in knots
    val wgst: Long? = null, // Wind gust speed in knots
    @Serializable(with = VisibilitySerializer::class)
    val visib: Float?, // Visibility, parsed into a float (e.g., statute miles)
    val altim: Double, // Altimeter in inches of Mercury (inHg)
    val slp: Double? = null, // Sea level pressure in hPa
    val qcField: Long,
    val wxString: String? = null,
    val presTend: Double? = null,
    val maxT: Double? = null,
    val minT: Double? = null,
    val maxT24: Double? = null, // Max temp in 24h
    val minT24: Double? = null, // Min temp in 24h
    val precip: Double? = null, // Precipitation amount

    @SerialName("pcp3hr")
    val pcp3Hr: Double? = null, // Precipitation in last 3 hours

    @SerialName("pcp6hr")
    val pcp6Hr: Double? = null, // Precipitation in last 6 hours

    @SerialName("pcp24hr")
    val pcp24Hr: Double? = null, // Precipitation in last 24 hours

    val snow: Double? = null, // Snow depth
    val vertVis: Long? = null, // Vertical visibility in feet
    val metarType: String,
    val rawOb: String,
    val mostRecent: Long,
    val lat: Double,
    val lon: Double,
    val elev: Long, // Elevation in feet
    val prior: Long,
    val name: String,
    val clouds: List<Cloud>
)