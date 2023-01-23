package com.codingwithmitch.kmm_learning_mitch.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
//import androidx.navigation.compose.navigate
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation()
{
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination =Screen.ReceipeList.route )
    {
        composable(route = Screen.ReceipeList.route)
        {navBackStackEntry ->
            Column()
            {
                Text("RecipeListScreen")
                Divider()
                Button(onClick = { navController.navigate(Screen.ReceipeDetail.route) })
                {
                    Text("Go to RecipeDetail")
                }
            }
        }


        composable(route = Screen.ReceipeDetail.route)
        {navBackStackEntry ->
           Text("ReceipeDetialScreen")
        }
    }
}