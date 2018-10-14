package footballapi.novan.dicoding.footballapi.api

import android.net.Uri
import footballapi.novan.dicoding.footballapi.BuildConfig

object TheSportDBApi {
    fun getTeams(league:String?):String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/search_all_teams.php?l=" + league
    }

    fun getTeamDetail(teamId: String?): String{
        return BuildConfig.BASE_URL + "api/v1/json/${BuildConfig.TSDB_API_KEY}" + "/lookupteam.php?id=" + teamId
    }
}