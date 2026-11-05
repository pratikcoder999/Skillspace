package com.example.practice.SkillSpace

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class TrendingPlaylist(
    val title: String,
    val creator: String,
    val likes: String,
    val isVerified: Boolean = true
)

@Composable
fun TrendCard(playlist: TrendingPlaylist) {
    val DeepOrange = Color(0xFFCC5500)
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1A1A1A)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = playlist.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    if (playlist.isVerified) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Verified",
                            tint = Color(0xFF03A9F4),
                            modifier = Modifier
                                .padding(start = 6.dp)
                                .size(18.dp)
                        )
                    }
                }
                Text(
                    text = "by ${playlist.creator}",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Likes",
                    tint = DeepOrange,
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = playlist.likes,
                    modifier = Modifier.padding(start = 4.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun TrendList(navController: NavHostController, paddingValues: PaddingValues = PaddingValues(0.dp)) {
    val playlists = listOf(
        TrendingPlaylist("Jetpack Compose Masterclass", "Android Dev Pro", "12.5k"),
        TrendingPlaylist("Full Stack MERN Path", "CodeAcademy", "45.2k"),
        TrendingPlaylist("Deep Learning Specialization", "AI Scholar", "89.1k"),
        TrendingPlaylist("Unreal Engine 5 Basics", "GameStudio", "15.7k"),
        TrendingPlaylist("Kubernetes for Beginners", "Cloud Native", "22.3k"),
        TrendingPlaylist("Data Science with Python", "DataExpert", "34.8k"),
        TrendingPlaylist("React Native Deep Dive", "MobileDev Guru", "18.9k"),
        TrendingPlaylist("System Design Fundamentals", "ArchMaster", "56.4k"),
        TrendingPlaylist("Go Programming Language", "GopherSchool", "11.2k")
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        color = Color.Black
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Trending Playlists",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.LightGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            items(playlists) { playlist ->
                TrendCard(playlist = playlist)
            }
        }
    }
}
