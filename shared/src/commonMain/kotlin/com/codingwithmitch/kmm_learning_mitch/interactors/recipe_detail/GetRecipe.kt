package com.codingwithmitch.kmm_learning_mitch.interactors.recipe_detail

import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.model.UiComponentType
import com.codingwithmitch.kmm_learning_mitch.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetRecipe(private val recipeService: RecipeService)
{
    fun excute(id:Int):Flow<DataState<Recipe>>
    {
        return flow()
        {
            emit(DataState.isLoading())
            try
            {   /*I used recipeService becuase there was a problem in recipeCache*/
                val recipe=recipeService.get(id)
                emit(DataState(null,recipe))
            }catch (e:Exception)
            {
                emit(DataState.error<Recipe>(
                    message = GenericMessageInfo.Builder()
                        .id("SearchRecipes.Error")
                        .title("Error")
                        .uiComponentType(UiComponentType.Dialog)
                        .description(e.message?:"Unknown Error")))
            }


        }
    }

}