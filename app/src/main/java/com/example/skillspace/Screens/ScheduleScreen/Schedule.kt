package com.example.practice.SkillSpace

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class RoadmapStep(
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)

data class TrackRoadmap(
    val trackName: String,
    val steps: List<RoadmapStep>
)

@Composable
fun RoadmapStepItem(step: RoadmapStep, isLast: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(32.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(
                        if (step.isCompleted) Color(0xFFCC5500) else Color.Gray,
                        CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (step.isCompleted) {
                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(40.dp)
                        .background(Color.Gray)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.padding(bottom = 16.dp)) {
            Text(
                text = step.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = step.description,
                fontSize = 14.sp,
                color = Color.LightGray
            )
        }
    }
}

@Composable
fun TrackRoadmapCard(roadmap: TrackRoadmap) {
    val DeepOrange = Color(0xFFCC5500)
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E1E1E),
            contentColor = Color.White
        ),
        border = BorderStroke(1.dp, DeepOrange)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = roadmap.trackName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = DeepOrange,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            roadmap.steps.forEachIndexed { index, step ->
                RoadmapStepItem(step = step, isLast = index == roadmap.steps.size - 1)
            }
        }
    }
}

@Composable
fun Schedule(navController: NavHostController) {
    val roadmaps = listOf(
        TrackRoadmap(
            "Android App Development",
            listOf(
                RoadmapStep("Kotlin Fundamentals", "Master variables, control flow, and OOP.", true),
                RoadmapStep("Jetpack Compose UI", "Build modern UIs with declarative syntax.", true),
                RoadmapStep("State Management", "Understand ViewModel, LiveData, and Flow.", false),
                RoadmapStep("Networking & API", "Connect to the web using Retrofit and Coroutines.", false),
                RoadmapStep("Local Persistence", "Use Room Database for offline storage.", false)
            )
        ),
        TrackRoadmap(
            "Web Development",
            listOf(
                RoadmapStep("HTML & CSS", "Structure and style responsive web pages.", true),
                RoadmapStep("JavaScript Basics", "Logic, DOM manipulation, and ES6+.", true),
                RoadmapStep("Frontend Frameworks", "Master React, Vue, or Angular.", false),
                RoadmapStep("Backend Development", "Build APIs with Node.js or Python.", false),
                RoadmapStep("Deployment", "Host your site on Vercel, Netlify, or AWS.", false)
            )
        ),
        TrackRoadmap(
            "AI-ML",
            listOf(
                RoadmapStep("Python for Data Science", "NumPy, Pandas, and Matplotlib.", true),
                RoadmapStep("Mathematics for ML", "Linear Algebra, Calculus, and Statistics.", false),
                RoadmapStep("Supervised Learning", "Regression and Classification models.", false),
                RoadmapStep("Deep Learning", "Neural Networks with TensorFlow or PyTorch.", false),
                RoadmapStep("MLOps", "Deploying and monitoring models in production.", false)
            )
        ),
        TrackRoadmap(
            "Game Development",
            listOf(
                RoadmapStep("C# Programming", "Foundations for Unity development.", true),
                RoadmapStep("Unity/Unreal Engine Basics", "Navigating the editor and scenes.", false),
                RoadmapStep("Game Physics", "Collisions, rigid bodies, and forces.", false),
                RoadmapStep("AI & Pathfinding", "Creating smart NPC behavior.", false),
                RoadmapStep("Asset Pipeline", "3D Modeling and texture mapping.", false)
            )
        ),
        TrackRoadmap(
            "Cloud Computing & DevOps",
            listOf(
                RoadmapStep("Linux Administration", "Mastering the command line.", true),
                RoadmapStep("Containerization", "Docker basics and image creation.", false),
                RoadmapStep("Orchestration", "Kubernetes cluster management.", false),
                RoadmapStep("CI/CD Pipelines", "Automating builds with GitHub Actions.", false),
                RoadmapStep("Cloud Infrastructure", "AWS, Azure, or Google Cloud Platform.", false)
            )
        ),
        TrackRoadmap(
            "Data Analytics",
            listOf(
                RoadmapStep("Excel & SQL", "Data cleaning and relational queries.", true),
                RoadmapStep("Statistical Analysis", "Hypothesis testing and distributions.", false),
                RoadmapStep("Visualization Tools", "Power BI and Tableau dashboards.", false),
                RoadmapStep("Python for Analytics", "Automating reports with scripts.", false),
                RoadmapStep("Big Data basics", "Introduction to Hadoop and Spark.", false)
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    text = "Learning Schedules",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.LightGray,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
            
            items(roadmaps) { roadmap ->
                TrackRoadmapCard(roadmap = roadmap)
            }
        }
    }
}
