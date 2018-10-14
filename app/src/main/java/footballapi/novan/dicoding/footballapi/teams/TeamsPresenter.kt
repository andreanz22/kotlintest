package footballapi.novan.dicoding.footballapi.teams

import com.dicoding.kotlinacademy.teams.TeamsView
import footballapi.novan.dicoding.footballapi.api.ApiRepository
import footballapi.novan.dicoding.footballapi.api.TheSportDBApi
import footballapi.novan.dicoding.footballapi.model.TeamResponse
import footballapi.novan.dicoding.footballapi.util.CoroutineContextProvider
import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class TeamsPresenter(private val view: TeamsView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson, private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getTeamList(league: String?) {
        view.showLoading()

        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository
                        .doRequest(TheSportDBApi.getTeams(league)),
                        TeamResponse::class.java
                )
            }
            view.showTeamList(data.await().teams)
            view.hideLoading()
        }
    }
}