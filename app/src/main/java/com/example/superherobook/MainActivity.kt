package com.example.superherobook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.superherobook.ui.theme.SuperHeroBookTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {

    private val superheroList = ArrayList<Superhero>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // navigasyon kısmı
            val navController = rememberNavController() // dependencies icine eklememiz gerekti
            


            SuperHeroBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)){
                        NavHost(navController = navController,
                            startDestination = "list_screen") {
                            //baslangıc ekranını ayarladık
                            composable("list_screen") {
                                getData()
                                SuperheroList(superheros = superheroList,navController)
                            }
                            composable("detail_screen/{superhero}",
                                arguments = listOf(
                                    navArgument("superhero"){
                                        type = NavType.StringType
                                    }
                                )
                            ) {
                                val heroString = remember {
                                    it.arguments?.getString("superhero")
                                }
                                val selectedHero =Gson().fromJson(heroString,Superhero::class.java)
                                DetailScreen(superhero = selectedHero)
                            }
                        }

                    }
                }
            }
        }
    }

    private fun getData() {

            val superman = Superhero("Superman","DC",R.drawable.superman)
            val batman = Superhero("Batman","DC",R.drawable.batman)
            val ironman = Superhero("Iron Man","Marvel",R.drawable.ironman)
            val aquaman = Superhero("Aquaman","DC",R.drawable.aquaman)
            val deadpool = Superhero("Deadpool","Marvel",R.drawable.deadpool)

            superheroList.add(superman)
            superheroList.add(batman)
            superheroList.add(ironman)
            superheroList.add(aquaman)
            superheroList.add(deadpool)
            superheroList.add(superman)
            superheroList.add(batman)
            superheroList.add(ironman)
            superheroList.add(aquaman)
            superheroList.add(deadpool)
            superheroList.add(superman)
            superheroList.add(batman)
            superheroList.add(ironman)
            superheroList.add(aquaman)
            superheroList.add(deadpool)
            superheroList.add(superman)
            superheroList.add(batman)
            superheroList.add(ironman)
            superheroList.add(aquaman)
            superheroList.add(deadpool)

    }
}




