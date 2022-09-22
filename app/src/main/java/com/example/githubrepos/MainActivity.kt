package com.example.githubrepos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.githubrepos.ui.components.BottomNavItem
import com.example.githubrepos.ui.pages.FavoritePage
import com.example.githubrepos.ui.pages.GitHubPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainPage()
        }
    }
}

@Composable
fun mainPage(){
    val navController = rememberNavController()
    val items = listOf(BottomNavItem.GitHubBottomNav, BottomNavItem.FavoriteBottomNav)
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(painterResource(id = screen.icon), contentDescription = null) },
                        selected = currentDestination?.hierarchy?.any {
                            it.route == screen.screen_route } == true,
                        onClick = {
                            navController.navigate(screen.screen_route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        })
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = BottomNavItem.GitHubBottomNav.screen_route,
            Modifier.padding(innerPadding)) {
            composable(BottomNavItem.GitHubBottomNav.screen_route) {
                GitHubPage()
            }
            composable(BottomNavItem.FavoriteBottomNav.screen_route) {
                FavoritePage()
            }
        }
    }
}