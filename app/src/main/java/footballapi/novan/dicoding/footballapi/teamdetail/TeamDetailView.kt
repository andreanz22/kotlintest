package footballapi.novan.dicoding.footballapi.teamdetail

import footballapi.novan.dicoding.footballapi.model.Team

interface TeamDetailView {

    fun showLoading()
    fun hideLoading()
    fun showTeamDetail(data : List<Team>)

}