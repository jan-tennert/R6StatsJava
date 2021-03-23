package de.jan.r6statsjava

import org.json.JSONObject

class R6WeaponStats(data: JSONObject) {

    val lastUpdated = data.getString("last_updated").toDate()
    val weapons: Array<R6Weapon>

    init {
        val we = arrayListOf<R6Weapon>()
        for (any in data.getJSONArray("weapons")) {
            val wep = any as JSONObject
            we.add(R6Weapon(wep))
        }
        weapons = we.toTypedArray()
    }

    fun getWeapon(weapon: String, ignoreCase: Boolean = true) : R6Weapon? {
        var wc: R6Weapon? = null
        for (ca in weapons) {
            if(ignoreCase && ca.weapon.equals(weapon, ignoreCase = true)) {
                wc = ca
            } else if(!ignoreCase && ca.weapon == weapon) {
                wc = ca
            }
        }
        return wc
    }

}