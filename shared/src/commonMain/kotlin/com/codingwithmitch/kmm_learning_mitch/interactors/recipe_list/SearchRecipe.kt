package com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list

import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipe(private val recipeService:RecipeService, )
{
    fun excute(page:Int,query:String):Flow<List<Recipe>>
    {
        return flow()
        {
            try
            {
                val recipes=recipeService.search(page,query)
                emit(recipes)
            }catch (e:Exception)
            {

            }
        }
    }







}