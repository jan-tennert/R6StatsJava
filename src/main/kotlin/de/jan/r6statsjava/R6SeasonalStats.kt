package de.jan.r6statsjava

import de.jan.jkutils.toDate
import org.json.JSONObject

class R6SeasonalStats(private val data: JSONObject) {

    val lastUpdated = data.getString("last_updated").replace("T", "").replace("Z", "").toDate("yyyy-MM-ddHH:mm:ss.SSS")

    val seasons = arrayListOf<R6Season>()
    val crimsonHeist = getSeason("crimson_heist", true)
    val paraBellum = getSeason("para_bellum", true)
    val voidEdge = getSeason("void_edge", true)
    val steelWave = getSeason("steel_wave", true)
    val grimSky = getSeason("grim_sky", true)
    val phantomSight = getSeason("phantom_sight", true)
    val health = getSeason("health", true)
    val neonDawn = getSeason("neon_dawn", true)
    val bloodOrchid = getSeason("blood_orchid", true)
    val chimera = getSeason("chimera", true)
    val whiteNoise = getSeason("white_noise", true)
    val shadowLegacy = getSeason("shadow_legacy", true)
    val shiftingTides = getSeason("shifting_tides", true)
    val burntHorizon = getSeason("burnt_horizon", true)
    val emberRise = getSeason("ember_rise", true)
    val windBastion = getSeason("wind_bastion", true)


    fun getSeason(season: String) : R6Season {
        if(!data.getJSONObject("seasons").has(season)) throw R6StatsException("Season wasn't found")
        return R6Season(data.getJSONObject("seasons").getJSONObject(season))
    }

    private fun getSeason(season: String, addToSeasons: Boolean) : R6Season {
        if(!data.getJSONObject("seasons").has(season)) throw R6StatsException("Season wasn't found")
        val r6season = R6Season(data.getJSONObject("seasons").getJSONObject(season))
        seasons.add(r6season)
        return r6season
    }

}