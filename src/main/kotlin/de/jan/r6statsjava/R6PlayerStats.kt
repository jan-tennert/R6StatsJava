package de.jan.r6statsjava

import org.json.JSONObject

class R6PlayerStats(data: JSONObject) {

    init {
        println(data)
        println(data.getInt("kills"))
    }

    val kills = data.getLong("kills")
    val wins = data.getLong("wins")
    val penetrationKills = data.getLong("penetration_kills")
    val bulletsHit = data.getLong("bullets_hit")
    val reinforcementsDeployed = data.getLong("reinforcements_deployed")
    val gadgetsDestroyed = data.getLong("gadgets_destroyed")
    val gamesPlayed = data.getLong("games_played")
    val playTime = R6GameTime(data.getLong("playtime"))
    val losses = data.getLong("losses")
    val revives = data.getLong("revives")
    val barricadesDeployed = data.getLong("barricades_deployed")
    val blindKills = data.getLong("blind_kills")
    val bulletFired = data.getLong("bullets_fired")
    val headshots = data.getLong("headshots")
    val suicides = data.getLong("suicides")
    val assists = data.getLong("assists")
    val rappelBreaches = data.getLong("rappel_breaches")
    val wl = data.getDouble("wl")
    val draws = data.getLong("draws")
    val kd = data.getDouble("kd")
    val dbnos = data.getLong("dbnos")
    val meleeKills = data.getLong("melee_kills")
    val deaths = data.getLong("deaths")

}