package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list.SearchRecipes
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
        loadRecipe()
    }
    private fun loadRecipe()
    {
        searchRecipes.excute(page = state.value.page, query = state.value.query)
            .onEach()
            {dataState ->
                state.value=state.value.copy(isLoading = dataState.isLoading)

                dataState.data?.let()
                {recipes->
                    appendRecipes(recipes = recipes)
                }
                dataState.message?.let()
                {message->
                    Log.i("mag2851->RecipeListMsg:", message)
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