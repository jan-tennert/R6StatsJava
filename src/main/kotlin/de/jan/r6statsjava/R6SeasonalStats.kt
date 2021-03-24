package de.jan.r6statsjava

import org.json.JSONObject

class R6SeasonalStats(private val data: JSONObject) {

    val lastUpdated = data.getString("last_updated").toDate()

    val crimsonHeist = getSeason("crimson_heist")
    val paraBellum = getSeason("para_bellum")
    val voidEdge = getSeason("void_edge")
    val steelWave = getSeason("steel_wave")
    val grimSky = getSeason("grim_sky")
    val phantomSight = getSeason("phantom_sight")
    val health = getSeason("health")
    val neonDawn = getSeason("neon_dawn")
    val bloodOrchid = getSeason("blood_orchid")
    val chimera = getSeason("chimera")
    val whiteNoise = getSeason("white_noise")
    val shadowLegacy = getSeason("shadow_legacy")
    val shiftingTides = getSeason("shifting_tides")
    val burntHorizon = getSeason("burnt_horizon")
    val emberRise = getSeason("ember_rise")
    val windBastion = getSeason("wind_bastion")

    fun getSeason(season: String) : R6Season {
        if(!data.getJSONObject("seasons").has(season)) throw R6StatsException("Season wasn't found")
        return R6Season(data.getJSONObject("seasons").getJSONObject(season))
    }

}