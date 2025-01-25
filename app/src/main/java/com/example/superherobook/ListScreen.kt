package com.example.superherobook

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.gson.Gson


@Composable
fun SuperheroList (superheros: List<Superhero>,navController: NavController){
    // recyclerview yerine lazyColumn kullanıyoruz
    LazyColumn(
        Modifier.padding(5.dp).fillMaxSize().
    background(color = MaterialTheme.colorScheme.inversePrimary)) {
        items(superheros){
            SuperheroRow( superhero = it, navController = navController)
        }
    }
}


@Composable
fun SuperheroRow(superhero: Superhero,navController: NavController){
    Column(modifier = Modifier.
    fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.surfaceDim)
        .clickable {
            /* tıklandıgında diger ekrana gitmesi icin
                funciton a navcontroller parametresi ekledik
            */
            navController.navigate(
                "detail_screen/${
                    Gson().toJson(superhero)}"
            )
        }
    ){

        Text(superhero.name
            , style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(superhero.universe
            , style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.SemiBold
        )

        }

        }
