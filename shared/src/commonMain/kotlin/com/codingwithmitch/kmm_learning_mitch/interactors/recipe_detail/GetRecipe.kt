package com.codingwithmitch.kmm_learning_mitch.interactors.recipe_detail

import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.descriptors.PrimitiveKind

class GetRecipe(private val recipeService:RecipeService)
{
    fun excute(id:Int):Flow<DataState<Recipe>>
    {
        return flow()
        {
            emit(DataState.isLoading())
            try
            {
                val recipe=recipeService.get(id)
                emit(DataState(null,recipe))
            }catch (e:Exception)
            {
                emit(DataState<Recipe>(message = e.message?: "UnNown Error"))
            }


        }
    }

}