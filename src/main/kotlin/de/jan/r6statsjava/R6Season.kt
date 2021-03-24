package de.jan.r6statsjava

import org.json.JSONObject
import java.text.SimpleDateFormat

class R6Season(data: JSONObject) {

    private val formatter = SimpleDateFormat("yyyy-MM-dd")
    val startDate = formatter.parse(data.getString("start_date"))
    val endDate = if(data.isNull("end_date")) null else formatter.parse(data.getString("end_date"))
    val region = (data.getJSONObject("regions").getJSONArray("ncsa")[0] as JSONObject)
    val nextRankMMR = region.getLong("next_rank_mmr")
    val kills = if(region.isNull("kills")) 0 else region.getLong("kills")
    val maxRankText = region.getString("max_rank_text")
    val losses = if(region.isNull("losses")) 0 else region.getLong("losses")
    val championsRankPosition = region.getInt("champions_rank_position")
    val mmr = if(region.isNull("mmr")) 0 else region.getInt("mmr")
    val rank = region.getInt("rank")
    val deaths = region.getLong("deaths")
    val wins = region.getLong("wins")
    val rankText = region.getString("rank_text")
    val maxMMR = region.getInt("max_mmr")
    val abandons = region.getInt("abandons")
    val seasonId = region.getInt("season_id")
    val maxRankImage = region.getString("max_rank_image")
    val lastMatchMMRChange = region.getInt("last_match_mmr_change")
    val maxRank = region.getInt("max_rank")
    val prevRankMMR = region.getLong("prev_rank_mmr")
    val rankImage = region.getString("rank_image")
    val seasonName = data.getString("name")
}