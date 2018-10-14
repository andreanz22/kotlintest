package footballapi.novan.dicoding.footballapi.teamdetail

import com.google.gson.Gson
import footballapi.novan.dicoding.footballapi.api.ApiRepository
import footballapi.novan.dicoding.footballapi.api.TheSportDBApi
import footballapi.novan.dicoding.footballapi.model.TeamResponse
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamDetailPresenter(private val view: TeamDetailView,
                          private val apiRepository: ApiRepository,
                          private val gson: Gson) {

    fun getTeamDetail(idTeam:String){
        view.showLoading()
//        doAsync {
//            val data= gson.fromJson(apiRepository
//                    .doRequest(TheSportDBApi.getTeamDetail(idTeam)),
//                    TeamResponse::class.java)
//
//            uiThread {
//                view.hideLoading()
//                view.showTeamDetail(data.teams)
//            }
//
//        }

        async(UI){
            val data= bg {
                gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getTeamDetail(idTeam)),
                    TeamResponse::class.java)
            }
            view.showTeamDetail(data.await().teams)
        }
    }

}