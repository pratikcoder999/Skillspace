package com.example.practice.SkillSpace

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppTopBar() {

    val DeepOrange = Color(0xFFCC5500)

    CenterAlignedTopAppBar(

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(DeepOrange),

        title = {
            Text(
                text = "SkillSpace",
                fontWeight = FontWeight.SemiBold,
                fontSize = 27.sp,
                color = Color.Black
            )
        },

        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(36.dp),
                    tint = Color.Black
                )
            }
        },

        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Localized description",
                    modifier = Modifier.size(30.dp),
                    tint = Color.Black
                )
            }
        }

    )

}
