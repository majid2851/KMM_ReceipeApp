package com.codingwithmitch.kmm_learning_mitch.datasource.network

import com.codingwithmitch.kmm_learning_mitch.datasource.network.model.RecipeDto
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DatetimeUtil
import io.ktor.client.*

expect class KtorClientFactory() {
    fun build(): HttpClient
}

    fun RecipeDto.toRecipe(): Recipe
    {

        return Recipe(
            id=pk,
            title=title,
            featuredImage=featuredImage,
            rating = rating,
            publisher = publisher,
            sourceUrl = sourceUrl,
            ingredients = ingredients,
        )
    }

    fun List<RecipeDto>.toRecipeList(): List<Recipe>{
        return map{it.toRecipe()}
    }


