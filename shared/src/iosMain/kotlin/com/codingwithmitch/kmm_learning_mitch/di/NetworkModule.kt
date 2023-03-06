package com.codingwithmitch.kmm_learning_mitch.di

import com.codingwithmitch.kmm_learning_mitch.datasource.network.KtorClientFactory
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeServiceImpl

class NetworkModule
{
    val recipeService:RecipeService by lazy()
    {
        RecipeServiceImpl(
            httpClient = KtorClientFactory().build(),
            baseUrl = RecipeServiceImpl.BASE_URL
        )
    }
}