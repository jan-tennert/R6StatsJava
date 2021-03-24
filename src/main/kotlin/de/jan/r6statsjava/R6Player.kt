package de.jan.r6statsjava

import org.json.JSONObject

class R6Player(data: JSONObject) {

    val lastUpdated = data.getString("last_updated").toDate()

    val generalStats = R6PlayerStats(data.getJSONObject("stats").getJSONObject("general"))
    val gamemodeStats = R6GameModeStats(data.getJSONObject("stats").getJSONObject("gamemode"))

    val rankedStats = R6QueueStats(data.getJSONObject("stats").getJSONObject("queue").getJSONObject("ranked"))
    val casualStats = R6QueueStats(data.getJSONObject("stats").getJSONObject("queue").getJSONObject("casual"))
    val otherQueueStats = R6QueueStats(data.getJSONObject("stats").getJSONObject("queue").getJSONObject("other"))

    val level = data.getJSONObject("progression").getInt("level")
    val totalXP = data.getJSONObject("progression").getLong("total_xp")
    val lootboxProbability = data.getJSONObject("progression").getDouble("lootbox_probability")
    val platform = data.getString("platform")
    val username = data.getString("username")
    val ubisoftID = data.getString("ubisoft_id")
    val uplayID = if(data.has("uplay_id")) data.getString("uplay_id") else null
    val avatarURL146 = if(data.has("avatar_url_146")) data.getString("avatar_url_146") else null
    val avatarURL256 = if(data.has("avatar_url_256")) data.getString("avatar_url_256") else null

    override fun toString(): String {
        return username
    }

}