package footballapi.novan.dicoding.footballapi

import footballapi.novan.dicoding.footballapi.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}