package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_detail.GetRecipe
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailEvents
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(ExperimentalStdlibApi::class)
@HiltViewModel
class RecipeDetailViewModel @Inject
    constructor(private val savedStateHandle: SavedStateHandle,
                private val getRecipe: GetRecipe):ViewModel()
{
    val state:MutableState<RecipeDetailState> = mutableStateOf(RecipeDetailState())
    init
    {
        savedStateHandle.get<Int>("recipeId")?.let()
        { recipeId->
            viewModelScope.launch()
            {
                onTriggerEvent(RecipeDetailEvents.GetRecipe(recipeId))
            }

        }
    }

    fun onTriggerEvent(event:RecipeDetailEvents)
    {
        when(event)
        {
            is RecipeDetailEvents.GetRecipe->
            {
                getRecipe(event.recipeId)
            }
            else ->
            {
                 handleError("")
            }

        }
    }

    private fun handleError(error: String)
    {
        val queue=state.value.queue
        queue.add(error)
        state.value=state.value.copy(queue = queue)

    }

    private fun getRecipe(recipeId:Int)
    {
        getRecipe.excute(recipeId).onEach()
        {dataState ->
            Log.i("mag2851-RecipeLoad:","${dataState.isLoading}")

            dataState.data?.let()
            {it->

                state.value=state.value.copy(recipe = it)
            }
            dataState.message?.let()
            {message->
                handleError(message)
            }

        }.launchIn(viewModelScope)


    }

}