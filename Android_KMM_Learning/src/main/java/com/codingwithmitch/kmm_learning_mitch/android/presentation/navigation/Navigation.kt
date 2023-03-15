package com.codingwithmitch.kmm_learning_mitch.android.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.RecipeDetailScreen
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail.RecipeDetailViewModel
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.RecipeListScreen
import com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list.RecipeListViewModel
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailEvents

@Preview
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

               RecipeListScreen(myViewModel.state.value,onSelectRecipe = {recipeId->
                    navController.navigate(Screen.ReceipeDetail.route+"/$recipeId")
               }, onTrigerEvent = {myViewModel.trigerEvent(it)})
            }


        composable(route = Screen.ReceipeDetail.route+"/{recipeId}",
            arguments = listOf(navArgument("recipeId"){type=NavType.IntType}))
            {navBackStackEntry ->
                val factory= HiltViewModelFactory(LocalContext.current,navBackStackEntry)
                val myViewModel:RecipeDetailViewModel = viewModel(key="RecipeDetailViewModel",
                    factory = factory)

                RecipeDetailScreen(
                    state = myViewModel.state.value,
                    onTrigerEvent=myViewModel::onTriggerEvent)
            }
    }
}