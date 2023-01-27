package com.codingwithmitch.kmm_learning_mitch.datasource.network

import com.codingwithmitch.kmm_learning_mitch.datasource.network.model.RecipeDto
import com.codingwithmitch.kmm_learning_mitch.domain.model.RecipeModel
import io.ktor.client.*

expect class KtorClientFactory()
{
    fun build(): HttpClient

    fun RecipeDto.toRecipe():RecipeModel
    {
        return RecipeModel(
            id=pk,
            title=title,
            featuredImage=featuredImage,
            rating = rating,
            publisher = publisher,
            sourceUrl = sourceUrl,
            ingredientes = ingredients,
            dateAdded = ??,
            dateUpdated=??,


        )
    }

}
