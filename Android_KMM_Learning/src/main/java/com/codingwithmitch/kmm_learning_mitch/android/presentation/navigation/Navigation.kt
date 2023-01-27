package com.codingwithmitch.kmm_learning_mitch.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.RecipeDetailScreen
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.RecipeDetailViewModel
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.RecipeListScreen
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.RecipeListViewModel

@Composable
fun Navigation()
{
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination =Screen.ReceipeList.route )
    {
        composable(route = Screen.ReceipeList.route)
            {navBackStackEntry ->
                val factory= HiltViewModelFactory(LocalContext.current,navBackStackEntry)
                val myViewModel:RecipeListViewModel = viewModel(key="RecipeListViewModel",
                    factory = factory)

               RecipeListScreen(onSelectRecipe = {recipeId->
                    navController.navigate(Screen.ReceipeDetail.route+"/$recipeId")
               })
            }


        composable(route = Screen.ReceipeDetail.route+"/{recipeId}",
            arguments = listOf(navArgument("recipeId"){type=NavType.IntType}))
            {navBackStackEntry ->
                val factory= HiltViewModelFactory(LocalContext.current,navBackStackEntry)
                val myViewModel:RecipeDetailViewModel = viewModel(key="RecipeDetailViewModel",
                    factory = factory)

                RecipeDetailScreen(receipe = myViewModel.recipe.value)
            }
    }
}