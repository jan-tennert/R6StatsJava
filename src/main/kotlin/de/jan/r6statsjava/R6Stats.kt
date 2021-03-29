package de.jan.r6statsjava

import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONObject
import java.net.URLEncoder
import java.text.SimpleDateFormat
import java.util.*

/**
 * R6Stats API Key which you can create at https://r6stats.com/ (Discord Server)
 */
class R6Stats(private val apiKey: String) {

    private val okhttp = OkHttpClient()
    private val baseURL = "https://api2.r6stats.com/public-api/"

    init {
        if(makeRequest("stats/TheRealJanPANDA/pc/generic").toString().toLowerCase().contains("invalid api key")) throw R6StatsException("Invalid API Key")
    }

    /**
     * Get general stats like global kills, deaths or kills in a specific gamemode
     * @param username The rainbow six player username
     * @param platform The platform the rainbow six player is playing
     * @see Platform
     * @see R6Player
     */
    fun getR6PlayerStats(username: String, platform: Platform): R6Player {
        val name = URLEncoder.encode(username, "UTF-8")
        val result = makeRequest("stats/$name/${platform.key}/generic")
        checkForError(result.toString())
        return R6Player(result)
    }

    /**
     * Get stats for a specific season for example crimson heist kills, mmr, rank
     * @param username The rainbow six player username
     * @param platform The platform the rainbow six player is playing
     * @see Platform
     * @see R6SeasonalStats
     */
    fun getR6PlayerSeasonalStats(username: String, platform: Platform) : R6SeasonalStats {
        val name = URLEncoder.encode(username, "UTF-8")
        val result = makeRequest("stats/$name/${platform.key}/seasonal")
        checkForError(result.toString())
        return R6SeasonalStats(result)
    }

    /**
     * Get operator stats like kills with ash etc.
     * @param username The rainbow six player username
     * @param platform The platform the rainbow six player is playing
     * @see Platform
     * @see R6OperatorStats
     */
    fun getR6OperatorStats(username: String, platform: Platform) : R6OperatorStats {
        val name = URLEncoder.encode(username, "UTF-8")
        val result = makeRequest("stats/$name/${platform.key}/operators")
        checkForError(result.toString())
        return R6OperatorStats(makeRequest("stats/$username/${platform.key}/operators"))
    }

    /**
     * Get weapon category stats like kills with Assault Rifles
     * @param username The rainbow six player username
     * @param platform The platform the rainbow six player is playing
     * @see Platform
     * @see R6WeaponCategoryStats
     */
    fun getR6WeaponCategoryStats(username: String, platform: Platform) : R6WeaponCategoryStats {
        val name = URLEncoder.encode(username, "UTF-8")
        val result = makeRequest("stats/$name/${platform.key}/weapon-categories")
        checkForError(result.toString())
        return R6WeaponCategoryStats(makeRequest("stats/$username/${platform.key}/weapon-categories"))
    }

    /**
     * Get weapon stats like kills with the Commando 9
     * @param username The rainbow six player username
     * @param platform The platform the rainbow six player is playing
     * @see Platform
     * @see R6WeaponStats
     */
    fun getR6WeaponStats(username: String, platform: Platform) : R6WeaponStats {
        val name = URLEncoder.encode(username, "UTF-8")
        val result = makeRequest("stats/$name/${platform.key}/weapons")
        checkForError(result.toString())
        return R6WeaponStats(makeRequest("stats/$username/${platform.key}/weapons"))
    }

    /**
     * Get the top 100 players of a specific platform and region
     * @param platform - The platform for the leaderboard
     * @param region - The region for the leaderboard
     * @see Platform
     * @see Region
     * @see R6Leaderboard
     */
    fun getR6Leaderboard(platform: Platform, region: Region): R6Leaderboard {
        return R6Leaderboard(makeLeaderboardRequest("leaderboard/${platform.key}/${region.key}"))
    }

    private fun checkForError(data: String) {
        if(data.toLowerCase().contains("server_error")) throw R6StatsException("The player has no stats")
        if(data.toLowerCase().contains("no_records_found")) throw R6StatsException("Player not found on this platform")
    }

    private fun makeRequest(endpoint: String) : JSONObject {
        val request = Request.Builder()
            .url(baseURL + endpoint)
            .get()
            .addHeader("Authorization", "Bearer $apiKey")
            .build()
        return JSONObject(okhttp.newCall(request).execute().body!!.string())
    }

    private fun makeLeaderboardRequest(endpoint: String) : JSONArray {
        val request = Request.Builder()
            .url(baseURL + endpoint)
            .get()
            .addHeader("Authorization", "Bearer $apiKey")
            .build()
        return JSONArray(okhttp.newCall(request).execute().body!!.string())
    }

    enum class Platform(val key: String) {
        PC("pc"), PS4("ps4"), XBOX("xbox")
    }

    enum class Region(val key: String) {
        NCSA("ncsa"), EMEA("emea"), APAC("apac"), ALL("all")
    }

}

class R6StatsException(e: String) : Exception(e)