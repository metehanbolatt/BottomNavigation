package com.metehanbolat.bottomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.mutableStateOf
import com.metehanbolat.bottomnavigation.ui.customStuff.CustomBottomNavigation
import com.metehanbolat.bottomnavigation.ui.customStuff.Screen
import com.metehanbolat.bottomnavigation.ui.theme.BottomNavigationTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val currentScreen = mutableStateOf<Screen>(Screen.Home)

            BottomNavigationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        bottomBar = {
                            CustomBottomNavigation(currentScreenId = currentScreen.value.id){ screen ->
                                currentScreen.value = screen
                            }
                        }
                    ) {
                        
                    }
                }
            }
        }
    }
}
