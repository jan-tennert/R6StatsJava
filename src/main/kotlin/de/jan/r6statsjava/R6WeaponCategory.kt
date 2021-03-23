package de.jan.r6statsjava

import org.json.JSONObject

class R6WeaponCategory(data: JSONObject) {

    val kills = data.getLong("kills")
    val bulletsFired = data.getInt("bullets_fired")
    val headshots = data.getLong("headshots")
    val bulletsHit = data.getLong("bullets_hit")
    val kd = data.getDouble("kd")
    val category = data.getString("category")
    val headshotPercentage = data.getDouble("headshot_percentage")
    val deaths = data.getLong("deaths")
    val timesChosen = data.getInt("times_chosen")

}