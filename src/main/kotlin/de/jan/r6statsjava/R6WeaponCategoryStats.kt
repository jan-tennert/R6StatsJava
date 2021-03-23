package de.jan.r6statsjava

import org.json.JSONObject

class R6WeaponCategoryStats(data: JSONObject) {

    val lastUpdated = data.getString("last_updated").toDate()
    val categories: Array<R6WeaponCategory>

    init {
        val ca = arrayListOf<R6WeaponCategory>()
        for (any in data.getJSONArray("categories")) {
            val c = any as JSONObject
            ca.add(R6WeaponCategory(c))
        }
        categories = ca.toTypedArray()
    }

    fun getWeaponCategory(category: String, ignoreCase: Boolean = true) : R6WeaponCategory? {
        var wc: R6WeaponCategory? = null
        for (ca in categories) {
            if(ignoreCase && ca.category.equals(category, ignoreCase = true)) {
                wc = ca
            } else if(!ignoreCase && ca.category == category) {
                wc = ca
            }
        }
        return wc
    }

}