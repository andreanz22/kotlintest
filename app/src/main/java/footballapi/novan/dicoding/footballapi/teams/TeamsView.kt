package com.dicoding.kotlinacademy.teams

import footballapi.novan.dicoding.footballapi.model.Team

interface TeamsView {
    fun showLoading()
    fun hideLoading()
    fun showTeamList(data: List<Team>)
}