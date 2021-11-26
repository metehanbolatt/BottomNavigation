package com.metehanbolat.bottomnavigation.ui.customStuff

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val id: String,
    val title: String,
    val icon: ImageVector
){
    object Home : Screen("home","Home",Icons.Outlined.Home)
    object Search : Screen("search","Search",Icons.Outlined.Search)
    object Profile : Screen("profile","Profile",Icons.Outlined.Home)
    object Settings : Screen("settings","Settings",Icons.Outlined.Home)
}
