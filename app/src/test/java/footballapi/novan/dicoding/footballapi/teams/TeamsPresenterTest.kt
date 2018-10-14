package footballapi.novan.dicoding.footballapi.teams

import com.google.gson.Gson
import footballapi.novan.dicoding.footballapi.TeamsView
import footballapi.novan.dicoding.footballapi.TestContextProvider
import footballapi.novan.dicoding.footballapi.api.ApiRepository
import footballapi.novan.dicoding.footballapi.api.TheSportDBApi
import footballapi.novan.dicoding.footballapi.model.Team
import footballapi.novan.dicoding.footballapi.model.TeamResponse
import org.junit.Test

import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class TeamsPresenterTest {

    @Mock
    private
    lateinit var view: TeamsView

    @Mock
    private
    lateinit var gson: Gson

    @Mock
    private
    lateinit var apiRepository: ApiRepository

    private lateinit var presenter: TeamsPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter= TeamsPresenter(view,apiRepository,gson,TestContextProvider())
    }

    @Test
    fun getTeamList() {
        val teams: MutableList<Team> = mutableListOf()
        val response = TeamResponse(teams)
        val league = "English Premiere League"

        `when`(gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getTeams(league)),
                TeamResponse::class.java
        )).thenReturn(response)

        presenter.getTeamList(league)

        verify(view).showLoading()
        verify(view).showTeamList(teams)
        verify(view).hideLoading()
    }
}