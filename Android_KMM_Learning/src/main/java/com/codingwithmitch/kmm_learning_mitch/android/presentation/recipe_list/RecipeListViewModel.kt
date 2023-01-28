package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list.SearchRecipe
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel
    @Inject constructor(private val savedStateHandle: SavedStateHandle,
                        private val searchRecipe:SearchRecipe) :ViewModel()
{
    init {
        loadRecipe()
    }
    private fun loadRecipe()
    {
        searchRecipe.excute(page = 1, query = "chicken")
            .onEach()
            {dataState ->
                Log.i("mag2851-RecipeListLoad:","${dataState.isLoading}")

                dataState.data?.let()
                {recipe->
                    Log.i("mag2851-RecipeListItem:","${recipe}")
                }
                dataState.message?.let()
                {message->
                    Log.i("mag2851->RecipeListMsg:", message)
                }


            }.launchIn(viewModelScope)
    }





}