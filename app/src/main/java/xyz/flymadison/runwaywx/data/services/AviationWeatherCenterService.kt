package xyz.flymadison.runwaywx.data.services

import retrofit2.http.GET
import retrofit2.http.Query
import xyz.flymadison.runwaywx.data.models.Station

interface AviationWeatherCenterService {
    @GET("metar")
    suspend fun getMetarData(
        @Query("ids") stationIds: String,
        @Query("format") format: String = "json",
        @Query("taf") taf: Boolean = false,
    ): List<Station>
}