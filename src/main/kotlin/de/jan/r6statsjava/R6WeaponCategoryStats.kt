package de.jan.r6statsjava

import de.jan.jkutils.toDate
import org.json.JSONObject

class R6WeaponCategoryStats(private val data: JSONObject) {

    val lastUpdated = data.getString("last_updated").replace("T", "").replace("Z", "").toDate("yyyy-MM-ddHH:mm:ss.SSS")
    val categories: Array<R6WeaponCategory>
        get() {
            val ca = arrayListOf<R6WeaponCategory>()
            for (any in data.getJSONArray("categories")) {
                val c = any as JSONObject
                ca.add(R6WeaponCategory(c))
            }
            return ca.toTypedArray()
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

    fun sortWeaponCategoriesBy(value: R6WeaponCategory.SortValue) : Array<R6WeaponCategory> {
        val ops = categories
        ops.sortWith { o1, o2 ->
            when(value) {
                R6WeaponCategory.SortValue.KILLS -> o1.kills.compareTo(o2.kills)
                R6WeaponCategory.SortValue.HEADHSHOTS -> o1.headshots.compareTo(o2.headshots)
                R6WeaponCategory.SortValue.KD -> o1.kd.compareTo(o2.kd)
                R6WeaponCategory.SortValue.CATEGORY -> o1.category.compareTo(o2.category)
                R6WeaponCategory.SortValue.HEADSHOT_PERCENTAGE -> o1.headshotPercentage.compareTo(o2.headshotPercentage)
                R6WeaponCategory.SortValue.DEATHS -> o1.deaths.compareTo(o2.deaths)
                R6WeaponCategory.SortValue.TIMES_CHOSEN -> o1.timesChosen.compareTo(o2.timesChosen)
            }
        }
        ops.reverse()
        return ops
    }

}