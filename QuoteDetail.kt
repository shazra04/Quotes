package com.example.quoraapplication.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quoraapplication.models.Quote

@Composable
fun QuoteDetail(data:Quote){
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors =
                    listOf(Color.Gray, Color.White)
                )
            )){
        Card (elevation = 4.dp ,modifier = Modifier.padding(4.dp)){
            Column (verticalArrangement = Arrangement.Center, modifier = Modifier.align(Alignment.Center).padding(16.dp,24.dp)) {
                Image(imageVector = Icons.Filled.Favorite, contentDescription = "Icon",
                    modifier = Modifier.size(80.dp))
                Text(text = data.quote,style = MaterialTheme.typography.h6)
            }
        }
    }

}