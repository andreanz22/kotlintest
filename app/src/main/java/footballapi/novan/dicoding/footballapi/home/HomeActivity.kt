package footballapi.novan.dicoding.footballapi.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import footballapi.novan.dicoding.footballapi.R
import footballapi.novan.dicoding.footballapi.R.id.favorites
import footballapi.novan.dicoding.footballapi.R.id.teams
import footballapi.novan.dicoding.footballapi.R.layout.activity_home
import footballapi.novan.dicoding.footballapi.favorites.FavoriteTeamsFragment
import footballapi.novan.dicoding.footballapi.teams.TeamsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                teams -> {
                    loadTeamsFragment(savedInstanceState)
                }
                favorites -> {
                    loadFavoritesFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = teams
    }


    private fun loadTeamsFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.simpleName)
                    .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoriteTeamsFragment(), FavoriteTeamsFragment::class.simpleName)
                    .commit()
        }
    }
}