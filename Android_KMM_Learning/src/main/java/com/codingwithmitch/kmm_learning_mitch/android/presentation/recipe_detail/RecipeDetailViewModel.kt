package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.kmm_learning_mitch.android.di.Dummy
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeService
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DatetimeUtil
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@OptIn(ExperimentalStdlibApi::class)
@HiltViewModel
class RecipeDetailViewModel @Inject
    constructor(private val savedStateHandle: SavedStateHandle,
                private val recipeService: RecipeService
//                private val dummy: Dummy
                ):ViewModel()
{
    val recipe:MutableState<Recipe?> = mutableStateOf(null)
    init
    {
        savedStateHandle.get<Int>("recipeId")?.let { recipeId->
            viewModelScope.launch()
            {
                recipe.value=recipeService.get(recipeId)

                Log.i("mag2851","Ktor Test:${recipe.value!!.title}")
                Log.i("mag2851","Ktor Test:${recipe.value!!.ingredients}")
                Log.i("mag2851","Ktor Test:${DatetimeUtil().
                    humanizeDatetime(recipe.value!!.dateUpdated)}")
            }

        }

    }

}