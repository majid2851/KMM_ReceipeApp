package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list.SearchRecipes
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeListEvents
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeStateList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel
    @Inject constructor(private val savedStateHandle: SavedStateHandle,
                        private val searchRecipes:SearchRecipes) :ViewModel()
{
    val state:MutableState<RecipeStateList> = mutableStateOf(RecipeStateList())
    init {
        trigerEvent(RecipeListEvents.LoadRecipes)
    }
    fun trigerEvent(event:RecipeListEvents)
    {
        when(event)
        {
            RecipeListEvents.LoadRecipes ->
            {
                loadRecipe()
            }
            RecipeListEvents.nextPage->
            {
                goNextPage()
            }
            RecipeListEvents.newSearch->
            {
                newSearch()
            }
            is RecipeListEvents.onUpdateQuery->
            {
                state.value=state.value.copy(query = event.query)
            }
            else->
            {
                handleError("")
            }
        }



    }

    private fun newSearch() {
        state.value=state.value.copy(page = 1, recipe = listOf())
        loadRecipe()

    }

    private fun handleError(error:String) {


    }


    private fun goNextPage()
    {
        state.value=state.value.copy(page = state.value.page+1)
        loadRecipe()
    }

    private fun loadRecipe()
    {
        searchRecipes.excute(page = state.value.page, query = state.value.query)
            .onEach()
            {dataState ->
                state.value=state.value.copy(isLoading = dataState.isLoading)
                Log.i("mag2851-loading",dataState.isLoading.toString())

                dataState.data?.let()
                {recipes->
                    appendRecipes(recipes = recipes)
                }
                dataState.message?.let()
                {message->
                    handleError(message)
//                    Log.i("mag2851->RecipeListMsg:", message)
                }


            }.launchIn(viewModelScope)
    }
    private fun appendRecipes(recipes:List<Recipe>)
    {
        val curr=ArrayList(state.value.recipe)
        curr.addAll(recipes)
        state.value=state.value.copy(recipe = curr)


    }




}