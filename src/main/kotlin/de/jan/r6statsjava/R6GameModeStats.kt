package de.jan.r6statsjava

import org.json.JSONObject

class R6GameModeStats(data: JSONObject) {

    val hostageStats = Hostage(data.getJSONObject("hostage"))
    val secureAreaStats = SecureArea(data.getJSONObject("secure_area"))
    val bombStats = Bomb(data.getJSONObject("bomb"))

    class SecureArea(data: JSONObject) {
        val wins = data.getLong("wins")
        val bestScore = data.getLong("best_score")
        val wl = data.getDouble("wl")
        val killsAsDefender = data.getLong("kills_as_defender_in_objective")
        val killsAsAttacker = data.getLong("kills_as_attacker_in_objective")
        val losses = data.getLong("losses")
        val playTime = R6GameTime(data.getLong("playtime"))
        val gamesPlayed = data.getLong("games_played")
        val objectivesSecured = data.getLong("times_objective_secured")
    }

    class Hostage(data: JSONObject) {

        val wins = data.getLong("wins")
        val bestScore = data.getLong("best_score")
        val extractionsDenied = data.getLong("extractions_denied")
        val wl = data.getDouble("wl")
        val gamesPlayed = data.getLong("games_played")
        val playTime = R6GameTime(data.getLong("playtime"))
        val losses = data.getLong("losses")

    }

    class Bomb(data: JSONObject) {

        val wins = data.getLong("wins")
        val bestScore = data.getLong("best_score")
        val wl = data.getDouble("wl")
        val gamesPlayed = data.getLong("games_played")
        val playTime = R6GameTime(data.getLong("playtime"))
        val losses = data.getLong("losses")

    }

}