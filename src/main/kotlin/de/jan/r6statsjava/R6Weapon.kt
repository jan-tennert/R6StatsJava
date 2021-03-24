package de.jan.r6statsjava

import org.json.JSONObject

class R6Weapon(data: JSONObject) {

    val kills = data.getLong("kills")
    val bulletsFired = data.getInt("bullets_fired")
    val weapon = data.getString("weapon")
    val headshots = data.getLong("headshots")
    val bulletsHit = data.getLong("bullets_hit")
    val kd = data.getDouble("kd")
    val category = data.getString("category")
    val headshotsPercentage = data.getDouble("headshot_percentage")
    val deaths = data.getLong("deaths")
    val timesChosen = data.getLong("times_chosen")

    enum class SortValue {
        KILLS, WEAPON, KD, DEATHS, TIMES_CHOSEN, HEADSHOT_PERCENTAGE, HEADSHOTS
    }

}