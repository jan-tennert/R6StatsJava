package de.jan.r6statsjava

import org.json.JSONObject

class R6Operator(data: JSONObject) {

    val kills = data.getLong("kills")
    val wins = data.getLong("wins")
    val role = data.getString("role")
    val ctu = data.getString("ctu")
    val playTime = R6GameTime(data.getLong("playtime"))
    val losses = data.getLong("losses")
    val experience = data.getLong("experience")
    val abilities: Array<Ability>
    val headshots = data.getLong("headshots")
    val wl = data.getLong("wl")
    val name = data.getString("name")
    val kd = data.getDouble("kd")
    val dbnos = data.getDouble("dbnos")
    val meleeKills = data.getLong("melee_kills")
    val deaths = data.getLong("deaths")
    val image = if(data.has("badge_image")) data.getString("badge_image") else null

    init {
        val ab = arrayListOf<Ability>()
        if(data.has("abilities")) {
            for (any in data.getJSONArray("abilities")) {
                val a = any as JSONObject
                ab.add(Ability(a.getString("ability"), if(a.isNull("value")) 0 else a.getInt("value")))
            }
        }
        abilities = ab.toTypedArray()
    }

    class Ability(val ability: String, val value: Int)

    enum class SortValue {
        WINS, KILLS, DEATHS, KD, NAME, HEADSHOTS, WL, LOSSES, PLAYTIME
    }

}