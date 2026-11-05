package com.example.practice.SkillSpace

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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

data class ResourceLink(
    val title: String,
    val url: String,
    val type: String // e.g., "Official", "Tutorial", "Community"
)

data class TrackResources(
    val trackName: String,
    val links: List<ResourceLink>
)

@Composable
fun ResourceItem(resource: ResourceLink) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1A1A1A)
        ),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(0.5.dp, Color.DarkGray)
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = resource.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
                Text(
                    text = resource.url,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1
                )
            }
            Surface(
                color = when (resource.type) {
                    "Official" -> Color(0xFF00796B)
                    "Tutorial" -> Color(0xFFCC5500)
                    else -> Color(0xFF455A64)
                },
                shape = RoundedCornerShape(4.dp)
            ) {
                Text(
                    text = resource.type,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    fontSize = 10.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun TrackResourcesSection(track: TrackResources) {
    val DeepOrange = Color(0xFFCC5500)

    Column(modifier = Modifier.padding(vertical = 12.dp)) {
        Text(
            text = track.trackName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = DeepOrange,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        track.links.forEach { link ->
            ResourceItem(resource = link)
        }

        HorizontalDivider(
            modifier = Modifier.padding(top = 16.dp),
            color = Color.DarkGray,
            thickness = 0.5.dp
        )
    }
}

@Composable
fun Resources(navController: NavHostController) {
    val resourceData = listOf(
        TrackResources(
            "Android App Development",
            listOf(
                ResourceLink("Android Developer Docs", "developer.android.com", "Official"),
                ResourceLink("Kotlin Documentation", "kotlinlang.org", "Official"),
                ResourceLink("Android Tutorial - GFG", "geeksforgeeks.org/android-tutorial", "Tutorial"),
                ResourceLink("Jetpack Compose Samples", "github.com/android/compose-samples", "Community")
            )
        ),
        TrackResources(
            "Web Development",
            listOf(
                ResourceLink("MDN Web Docs", "developer.mozilla.org", "Official"),
                ResourceLink("W3Schools", "w3schools.com", "Tutorial"),
                ResourceLink("React Docs", "react.dev", "Official"),
                ResourceLink("Web Dev Roadmap - GFG", "geeksforgeeks.org/web-development", "Tutorial")
            )
        ),
        TrackResources(
            "AI-ML",
            listOf(
                ResourceLink("TensorFlow Guide", "tensorflow.org/learn", "Official"),
                ResourceLink("PyTorch Tutorials", "pytorch.org/tutorials", "Official"),
                ResourceLink("Machine Learning - GFG", "geeksforgeeks.org/machine-learning", "Tutorial"),
                ResourceLink("Scikit-Learn Docs", "scikit-learn.org", "Official")
            )
        ),
        TrackResources(
            "Game development",
            listOf(
                ResourceLink("Unity Documentation", "docs.unity3d.com", "Official"),
                ResourceLink("Unreal Engine Docs", "docs.unrealengine.com", "Official"),
                ResourceLink("Game Development - GFG", "geeksforgeeks.org/game-development", "Tutorial"),
                ResourceLink("Learn Unity", "learn.unity.com", "Official")
            )
        ),
        TrackResources(
            "Cloud Computing & DevOps",
            listOf(
                ResourceLink("AWS Documentation", "aws.amazon.com/docs", "Official"),
                ResourceLink("Docker Docs", "docs.docker.com", "Official"),
                ResourceLink("DevOps Roadmap - GFG", "geeksforgeeks.org/devops-tutorial", "Tutorial"),
                ResourceLink("Kubernetes Basics", "kubernetes.io/docs", "Official")
            )
        ),
        TrackResources(
            "Data analytics",
            listOf(
                ResourceLink("Power BI Learning", "learn.microsoft.com/power-bi", "Official"),
                ResourceLink("Tableau Training", "tableau.com/learn/training", "Official"),
                ResourceLink("Data Analytics - GFG", "geeksforgeeks.org/data-analysis", "Tutorial"),
                ResourceLink("Pandas Docs", "pandas.pydata.org", "Official")
            )
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top
        ) {
            item {
                Text(
                    text = "Learning Resources",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            items(resourceData) { track ->
                TrackResourcesSection(track = track)
            }
        }
    }
}
