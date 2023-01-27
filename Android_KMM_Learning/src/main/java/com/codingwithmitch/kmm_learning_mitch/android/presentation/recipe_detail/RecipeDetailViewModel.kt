package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.codingwithmitch.kmm_learning_mitch.android.di.Dummy
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject
    constructor(private val savedStateHandle: SavedStateHandle,
                private val dummy: Dummy):ViewModel()
{
    val recipeId:MutableState<Int?> = mutableStateOf(null)
    init
    {

        savedStateHandle.get<Int>("recipeId").let { recipeId->
            this.recipeId.value=recipeId
        }
        Log.i("mag2851",dummy.description())


    }





}