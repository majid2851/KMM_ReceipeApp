package com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail

sealed class RecipeDetailEvents
{
    data class GetRecipe(val recipeId:Int):RecipeDetailEvents()



    
}