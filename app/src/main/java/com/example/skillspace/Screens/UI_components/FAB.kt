package com.example.practice.SkillSpace

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FAB() {

    val DeepOrange = Color(0xFFCC5500)

    FloatingActionButton(
        onClick = { },
        modifier = Modifier.size(58.dp),
        containerColor = DeepOrange,
        shape = RoundedCornerShape(17),
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add",
            modifier = Modifier.size(35.dp)
        )
    }
}
