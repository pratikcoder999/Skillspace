package com.example.practice.SkillSpace

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.skillspace.R

@Composable
fun HomeContent(navController: NavHostController? = null) {

    val DeepOrange = Color(0xFFCC5500)

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black // Or MaterialTheme.colorScheme.background
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {

            item {
                Text(
                    text = "Active Tracks",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.LightGray
                )
            }

            item {
                Spacer(modifier = Modifier.height(15.dp))
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .clickable {
                            navController?.navigate(NavRoutes.PlayPreview)
                        },

                    shape = RoundedCornerShape(12.dp),
                    colors = cardColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    ),
                    border = BorderStroke(4.dp, DeepOrange)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                    )
                    {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color.Gray, CircleShape),
                        )
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                                contentDescription = "Android",
                            )
                        }
                        Column()
                        {
                            Text(
                                text = "Android App Development",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 13.dp)
                            )

                            Text(
                                text = "Full Stack native Dev",
                                fontSize = 19.sp,
                                modifier = Modifier.padding(13.dp)
                            )
                        }
                    }

                }
            }

            item {
                Spacer(modifier = Modifier.height(29.dp))
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),

                    shape = RoundedCornerShape(12.dp),
                    colors = cardColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    ),
                    border = BorderStroke(4.dp, DeepOrange)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                    )
                    {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color.Gray, CircleShape),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.Build,
                                contentDescription = "Android",
                                modifier = Modifier.size(35.dp),
                            )
                        }
                        Column()
                        {
                            Text(
                                text = "Web Development",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 13.dp)
                            )

                            Text(
                                text = "Full Stack Development",
                                fontSize = 19.sp,
                                modifier = Modifier.padding(13.dp)
                            )
                        }
                    }

                }
            }

            item {
                Spacer(modifier = Modifier.height(29.dp))
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),

                    shape = RoundedCornerShape(12.dp),
                    colors = cardColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    ),
                    border = BorderStroke(4.dp, DeepOrange)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                    )
                    {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color.Gray, CircleShape),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "Android",
                                modifier = Modifier.size(35.dp),
                            )
                        }
                        Column()
                        {
                            Text(
                                text = "AI-ML",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 13.dp)
                            )

                            Text(
                                text = "Machine Learning & AI integration",
                                fontSize = 19.sp,
                                modifier = Modifier.padding(13.dp)
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(29.dp))
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),

                    shape = RoundedCornerShape(12.dp),
                    colors = cardColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    ),
                    border = BorderStroke(4.dp, DeepOrange)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                    )
                    {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color.Gray, CircleShape),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight,
                                contentDescription = "Android",
                                modifier = Modifier.size(35.dp),
                            )
                        }
                        Column()
                        {
                            Text(
                                text = "Game development",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 13.dp)
                            )

                            Text(
                                text = "C#, unreal engine, design and development ",
                                fontSize = 19.sp,
                                modifier = Modifier.padding(13.dp)
                            )
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(29.dp))
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),

                    shape = RoundedCornerShape(12.dp),
                    colors = cardColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    ),
                    border = BorderStroke(4.dp, DeepOrange)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                    )
                    {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color.Gray, CircleShape),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.ExitToApp,
                                contentDescription = "Android",
                                modifier = Modifier.size(35.dp),
                            )
                        }
                        Column()
                        {
                            Text(
                                text = "Cloud Computing & DevOps",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 13.dp)
                            )

                            Text(
                                text = "Expertise in Cloud and Devops technologies",
                                fontSize = 19.sp,
                                modifier = Modifier.padding(13.dp)
                            )
                        }
                    }
                }

            }

            item {
                Spacer(modifier = Modifier.height(29.dp))
            }

            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),

                    shape = RoundedCornerShape(12.dp),
                    colors = cardColors(
                        containerColor = Color.LightGray,
                        contentColor = Color.Black,
                    ),
                    border = BorderStroke(4.dp, DeepOrange)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                    )
                    {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color.Gray, CircleShape),
                            contentAlignment = Alignment.Center
                        )
                        {
                            Icon(
                                imageVector = Icons.Default.Create,
                                contentDescription = "Android",
                                modifier = Modifier.size(35.dp),
                            )
                        }
                        Column()
                        {
                            Text(
                                text = "Data analytics",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(start = 13.dp)
                            )

                            Text(
                                text = "power BI, MS Excel, tableau & Creative Dashboard",
                                fontSize = 19.sp,
                                modifier = Modifier.padding(13.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewHomeContent() {
    HomeContent()
}
