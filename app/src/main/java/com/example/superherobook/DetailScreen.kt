package com.example.superherobook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(superhero: Superhero){
    Box(modifier = Modifier.fillMaxSize()
        .background(color = MaterialTheme.colorScheme.primary )
        , contentAlignment = Alignment.Center)
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(bitmap = ImageBitmap.imageResource(id = superhero.image),
                contentDescription = "",
                modifier = Modifier.padding(10.dp).size(350.dp,350.dp)
            )
            Text(text = superhero.name,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(3.dp))
            Text(text = superhero.universe,
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(3.dp))
        }
    }

}