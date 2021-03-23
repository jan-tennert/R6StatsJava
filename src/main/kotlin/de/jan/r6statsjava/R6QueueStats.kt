package de.jan.r6statsjava

import org.json.JSONObject

class R6QueueStats(data: JSONObject) {

    val kills = data.getLong("kills")
    val wins = data.getLong("wins")
    val wl = data.getDouble("wl")
    val draws = data.getLong("draws")
    val kd = data.getDouble("kd")
    val gamesPlayed = data.getLong("games_played")
    val playTime = R6GameTime(data.getLong("playtime"))
    val losses = data.getLong("losses")
    val deaths = data.getLong("deaths")

}