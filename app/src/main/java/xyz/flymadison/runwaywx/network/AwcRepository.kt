package xyz.flymadison.runwaywx.network

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xyz.flymadison.runwaywx.data.models.Station
import xyz.flymadison.runwaywx.data.services.AviationWeatherCenterService
import javax.inject.Inject
import javax.inject.Singleton

interface AwcRepository {
    fun getMetarData(ids: List<String>, format: String = "json", taf: Boolean = false): Flow<Result<List<Station>>>
}

@Singleton
class AwcRepositoryImpl @Inject constructor(
    private val apiService: AviationWeatherCenterService
) : AwcRepository {
    override fun getMetarData(ids: List<String>, format: String, taf: Boolean): Flow<Result<List<Station>>> {
        return flow {
            try {
                val idsString = ids.joinToString(",") { it.trim().uppercase() }
                val stationsData = apiService.getMetarData(
                    stationIds = idsString,
                    format = format,
                    taf = taf
                )
                emit(Result.success(stationsData))
            } catch (e: Exception) {
                emit(Result.failure(e))
            }
        }.flowOn(Dispatchers.IO)
    }
}