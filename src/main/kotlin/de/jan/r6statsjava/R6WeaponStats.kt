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

    fun sortWeaponsBy(value: R6Weapon.SortValue) : Array<R6Weapon> {
        val ops = weapons
        ops.sortWith { o1, o2 ->
            when(value) {
                R6Weapon.SortValue.DEATHS -> o1.deaths.compareTo(o2.deaths)
                R6Weapon.SortValue.KILLS -> o1.kills.compareTo(o2.kills)
                R6Weapon.SortValue.KD -> o1.kd.compareTo(o2.kd)
                R6Weapon.SortValue.WEAPON -> o1.weapon.compareTo(o2.weapon)
                R6Weapon.SortValue.HEADSHOTS -> o1.headshots.compareTo(o2.headshots)
                R6Weapon.SortValue.TIMES_CHOSEN -> o1.timesChosen.compareTo(o2.timesChosen)
                R6Weapon.SortValue.HEADSHOT_PERCENTAGE -> o1.headshotsPercentage.compareTo(o2.headshotsPercentage)
            }
        }
        ops.reverse()
        return ops
    }

}