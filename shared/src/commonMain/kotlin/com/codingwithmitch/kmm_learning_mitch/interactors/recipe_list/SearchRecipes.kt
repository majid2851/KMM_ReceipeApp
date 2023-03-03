package com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list

import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.model.UiComponentType
import com.codingwithmitch.kmm_learning_mitch.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRecipes(
    private val recipeService:RecipeService,
)
{
    fun excute(page:Int,query:String):Flow<DataState<List<Recipe>>>
    {
        return flow()
        {
            emit(DataState.isLoading())
            try
            {
                val recipes=recipeService.search(page,query)

                if (query.equals("error"))
                    throw Exception("mag2851")


//                delay(500)


                emit(DataState.data(message =null , data = recipes))
            }catch (e:Exception)
            {
                emit(DataState.error<List<Recipe>>(
                    message = GenericMessageInfo.Builder()
                    .id("SearchRecipes.Error")
                    .title("Error")
                    .uiComponentType(UiComponentType.Dialog)
                    .description(e.message?:"Unknown Error")
                ))
            }
        }
    }







}