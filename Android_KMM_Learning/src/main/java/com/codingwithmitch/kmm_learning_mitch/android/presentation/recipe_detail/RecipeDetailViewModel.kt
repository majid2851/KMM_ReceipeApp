package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_detail.GetRecipe
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
    val recipe:MutableState<Recipe?> = mutableStateOf(null)
    init
    {
        savedStateHandle.get<Int>("recipeId")?.let()
        { recipeId->
            viewModelScope.launch()
            {
                getRecipe(recipeId)
            }

        }
    }

    private fun getRecipe(recipeId:Int)
    {
        getRecipe.excute(recipeId).onEach()
        {dataState ->
            Log.i("mag2851-RecipeLoad:","${dataState.isLoading}")

            dataState.data?.let()
            {it->
                Log.i("mag2851-RecipeItem:","${it}")
                recipe.value=it
            }
            dataState.message?.let()
            {message->
                Log.i("mag2851->RecipeMsg:", message)
            }

        }.launchIn(viewModelScope)


    }

}