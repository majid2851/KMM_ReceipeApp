package com.codingwithmitch.kmm_learning_mitch.datasource.network

import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe

interface RecipeService
{
    suspend fun search(
        page:Int,
        query:String
    ):List<Recipe>

    suspend fun get(
        id:Int
    ):Recipe

}