package de.jan.r6statsjava

import org.json.JSONArray
import org.json.JSONObject

class R6Leaderboard(private val data: JSONArray) {

    val leaderboard: Array<R6LeaderboardPlayer>
        get() {
            val la = arrayListOf<R6LeaderboardPlayer>()
            for (any in data) {
                val pl = any as JSONObject
                la.add(R6LeaderboardPlayer(pl))
            }
            return la.toTypedArray()
        }

    fun getPlayerAtPosition(position: Int) : R6LeaderboardPlayer {
        if(position < 1 || position > 100) throw R6StatsException("The player position must be between 1 and 100")

        return leaderboard[position - 1]
    }

}