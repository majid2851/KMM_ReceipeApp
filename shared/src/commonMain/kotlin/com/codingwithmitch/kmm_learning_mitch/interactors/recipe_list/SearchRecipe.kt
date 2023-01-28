package com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list

import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipe(private val recipeService:RecipeService, )
{
    fun excute(page:Int,query:String):Flow<DataState<List<Recipe>>>
    {
        return flow()
        {
            emit(DataState.isLoading())
            try
            {
                val recipes=recipeService.search(page,query)
                emit(DataState.data(message =null , data = recipes))
            }catch (e:Exception)
            {
                emit(DataState.error<List<Recipe>>(message = e.message?:"UnKnown Error!"))
            }
        }
    }







}