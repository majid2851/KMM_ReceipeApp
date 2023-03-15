package com.codingwithmitch.kmm_learning_mitch.di

import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_detail.GetRecipe

class GetRecipeModule(private val networkModule: NetworkModule)
{
    val getRecipes:GetRecipe by lazy()
    {
        GetRecipe(recipeService = networkModule.recipeService)
    }



}