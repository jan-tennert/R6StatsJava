package de.jan.r6statsjava

import de.jan.jkutils.toDate
import org.json.JSONObject

class R6Season(data: JSONObject) {

    val startDate = data.getString("start_date").toDate("yyyy-MM-dd")
    val endDate = if(data.isNull("end_date")) null else data.getString("end_date").toDate("yyyy-MM-dd")
    val region = (data.getJSONObject("regions").getJSONArray("ncsa")[0] as JSONObject)
    val nextRankMMR = region.getLong("next_rank_mmr")
    val kills = if(region.isNull("kills")) 0 else region.getLong("kills")
    val maxRankText = region.getString("max_rank_text")
    val losses = if(region.isNull("losses")) 0 else region.getLong("losses")
    val championsRankPosition = if(region.isNull("champions_rank_position")) 0 else region.getInt("champions_rank_position")
    val mmr = if(region.isNull("mmr")) 0 else region.getInt("mmr")
    val rank = region.getInt("rank")
    val deaths = if(region.isNull("deaths")) 0 else region.getLong("deaths")
    val wins = region.getLong("wins")
    val rankText = region.getString("rank_text")
    val maxMMR = region.getInt("max_mmr")
    val abandons = region.getInt("abandons")
    val seasonId = region.getInt("season_id")
    val maxRankImage = region.getString("max_rank_image")
    val maxRankImagePNG = maxRankImage.replace("ranks", "rank-imgs").replace("svg", "png")
    val lastMatchMMRChange = if(region.isNull("last_match_mmr_change")) 0 else region.getInt("last_match_mmr_change")
    val maxRank = region.getInt("max_rank")
    val prevRankMMR = region.getLong("prev_rank_mmr")
    val rankImage = region.getString("rank_image")
    val rankImagePNG = rankImage.replace("ranks", "rank-imgs").replace("svg", "png")
    val seasonName = data.getString("name")
}