package com.example.githubrepos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.githubrepos.ui.favorite.FavoriteFragment
import com.example.githubrepos.ui.github.GitHubFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationView: BottomNavigationView
    val gitHubFragment = GitHubFragment()
    val favoriteFragment = FavoriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        supportFragmentManager.beginTransaction().replace(R.id.container,
        gitHubFragment).commit()

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.github -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.container, gitHubFragment).commit()
                    true
                }
                else -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.container, favoriteFragment).commit()
                    true
                }
            }
        }
    }
}
