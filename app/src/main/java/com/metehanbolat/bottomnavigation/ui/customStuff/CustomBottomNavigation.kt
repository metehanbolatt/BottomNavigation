package com.metehanbolat.bottomnavigation.ui.customStuff

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigation(
    currentScreenId: String,
    onItemSelected: (Screen) -> Unit
) {
    val items = Screen.Items.list

    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEach { item ->
            CustomBottomNavigationItem(item = item, isSelected = item.id == currentScreenId) {
                onItemSelected(item)
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun CustomBottomNavigationItem(
    item: Screen,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val background = if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor = if (isSelected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground

    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(background)
            .clickable(onClick = onClick)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = item.icon,
                contentDescription = "Item Icon",
                tint = contentColor
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text = item.title,
                    color = contentColor
                )
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun CustomBottomNavigationPreview() {
    CustomBottomNavigation(currentScreenId = Screen.Home.id){

    }
}

@ExperimentalAnimationApi
@Preview
@Composable
fun CustomBottomNavigationItemPreview() {
    CustomBottomNavigationItem(item = Screen.Home, isSelected = true) {
        
    }
}