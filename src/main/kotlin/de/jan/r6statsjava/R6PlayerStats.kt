package de.jan.r6statsjava

import org.json.JSONObject

class R6PlayerStats(data: JSONObject) {

    init {
        println(data)
        println(data.getInt("kills"))
    }

    val kills = data.getInt("kills")
    val wins = data.getInt("wins")
    val penetrationKills = data.getInt("penetration_kills")
    val bulletsHit = data.getInt("bullets_hit")
    val reinforcementsDeployed = data.getInt("reinforcements_deployed")
    val gadgetsDestroyed = data.getInt("gadgets_destroyed")
    val gamesPlayed = data.getInt("games_played")
    val playTime = R6GameTime(data.getInt("playtime"))
    val losses = data.getInt("losses")
    val revives = data.getInt("revives")
    val barricadesDeployed = data.getInt("barricades_deployed")
    val blindKills = data.getInt("blind_kills")
    val bulletFired = data.getInt("bullets_fired")
    val headshots = data.getInt("headshots")
    val suicides = data.getInt("suicides")
    val assists = data.getInt("assists")
    val rappelBreaches = data.getInt("rappel_breaches")
    val wl = data.getDouble("wl")
    val draws = data.getInt("draws")
    val kd = data.getDouble("kd")
    val dbnos = data.getInt("dbnos")
    val meleeKills = data.getInt("melee_kills")
    val deaths = data.getInt("deaths")

}