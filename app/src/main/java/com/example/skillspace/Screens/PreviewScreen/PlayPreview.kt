package com.example.skillspace.Screens.PreviewScreen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.navigation.NavHostController
import com.example.skillspace.R

data class PlaylistVideo(
    val title: String,
    val duration: String,
    val isCompleted: Boolean = false
)

data class SkillTrackPlaylist(
    val trackTitle: String,
    val playlistName: String,
    val thumbnailUrl: String,
    val progress: Float, // 0.0 to 1.0
    val videos: List<PlaylistVideo>
)

val samplePlaylist = SkillTrackPlaylist(
    trackTitle = "Android Development",
    playlistName = "Jetpack Compose for Beginners",
    thumbnailUrl = "",
    progress = 0.35f,
    videos = listOf(
        PlaylistVideo("Introduction to Compose", "12:45", true),
        PlaylistVideo("Layouts and Modifiers", "25:10", true),
        PlaylistVideo("State Management", "45:20"),
        PlaylistVideo("Navigation in Compose", "18:30"),
        PlaylistVideo("Working with Side Effects", "30:00"),
        PlaylistVideo("Theming and Styling", "22:15")
    )
)

@Composable
fun PlayPreview(
    navController: NavHostController? = null,
    playlist: SkillTrackPlaylist = samplePlaylist
) {
    PlaylistPreview(
        playlist = playlist,
        onVideoClick = {}
    )
}

@Composable
fun PlaylistPreview(
    playlist: SkillTrackPlaylist,
    onVideoClick: (PlaylistVideo) -> Unit = {}
){
    val DeepOrange = Color(0xFFCC5500)

    val context = LocalContext.current          // (for yt uri) - local context of the current app state to start an activity using intents

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(19.dp)
                ) {
                    // Card Banner for Thumbnail
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.DarkGray),
                            contentAlignment = Alignment.Center
                        ) {
                            // Image Background
                            Image(
                                painter = painterResource(id = R.drawable.screenshot_2026_08_25_211637),
                                contentDescription = "YouTube Thumbnail",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )

                            // Shallow Play Button Overlay
                            Surface(
                                modifier = Modifier.size(60.dp),
                                color = Color.Black.copy(alpha = 0.4f),
                                shape = CircleShape
                            ) {
                                IconButton(
                                    onClick = {
                                        val intent = Intent(Intent.ACTION_VIEW)
                                        intent.data =
                                            Uri.parse("https://www.youtube.com/watch?v=4O56p2h9Srw&list=PLUhfM8afLE_MOoV5jIAj4UTJ3o43LEmoc&pp=0gcJCf4COCosWNin")
                                        context.startActivity(intent)
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.PlayArrow,
                                        contentDescription = "Play",
                                        modifier = Modifier.size(36.dp),
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Progress Bar Section
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Overall Progress",
                                color = Color.LightGray,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "${(playlist.progress * 100).toInt()}%",
                                color = DeepOrange,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        LinearProgressIndicator(
                            progress = { playlist.progress },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(8.dp),
                            color = DeepOrange,
                            trackColor = Color(0xFF2A2A2A),
                            strokeCap = StrokeCap.Round,
                            gapSize = 0.dp,
                            drawStopIndicator = {}
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Video Links Header
                    Text(
                        text = "Playlist Content",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )

                    // Video List
                    playlist.videos.forEachIndexed { index, video ->
                        VideoListItem(
                            index = index + 1,
                            video = video,
                            onClick = { onVideoClick(video) }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun VideoListItem(
    index: Int,
    video: PlaylistVideo,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1A1A)
        ),
        shape = RoundedCornerShape(12.dp),
        border = if (video.isCompleted) null else BorderStroke(0.5.dp, Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Index Box
            Surface(
                modifier = Modifier.size(32.dp),
                color = if (video.isCompleted) Color(0xFF4CAF50) else Color.DarkGray,
                shape = RoundedCornerShape(8.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = index.toString(),
                        color = Color.White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = video.title,
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = video.duration,
                    color = Color.Gray,
                    fontSize = 12.sp
                )
            }

            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                tint = Color.Gray,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewScreen() {
    val samplePlaylist = SkillTrackPlaylist(
        trackTitle = "Android Development",
        playlistName = "Jetpack Compose for Beginners",
        thumbnailUrl = "",
        progress = 0.35f,
        videos = listOf(
            PlaylistVideo("Introduction to Compose", "12:45", true),
            PlaylistVideo("Layouts and Modifiers", "25:10", true),
            PlaylistVideo("State Management", "45:20"),
            PlaylistVideo("Navigation in Compose", "18:30"),
            PlaylistVideo("Working with Side Effects", "30:00"),
            PlaylistVideo("Theming and Styling", "22:15")
        )
    )

    PlaylistPreview(
        playlist = samplePlaylist,
        onVideoClick = {}
    )
}
