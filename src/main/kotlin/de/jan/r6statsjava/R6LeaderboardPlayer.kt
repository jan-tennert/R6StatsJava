package de.jan.r6statsjava

import org.json.JSONObject

class R6LeaderboardPlayer(data: JSONObject) {

    val username = data.getString("username")
    val platform = data.getString("platform")
    val ubisoft_id = data.getString("ubisoft_id")
    val uplay_id = data.getString("uplay_id")
    val avatarURL146 = data.getString("avatar_url_146")
    val avatarURL256 = data.getString("avatar_url_256")
    val level = if(data.getJSONObject("stats").isNull("level")) null else data.getJSONObject("stats").getInt("level")
    val kd = if(data.getJSONObject("stats").isNull("kd")) null else data.getJSONObject("stats").getDouble("kd")
    val wl = if(data.getJSONObject("stats").isNull("wl")) null else data.getJSONObject("stats").getDouble("wl")
    val score = data.getDouble("score")
    val position = data.getInt("position")

}