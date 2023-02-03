package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_detail

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.model.UiComponentType
import com.codingwithmitch.kmm_learning_mitch.domain.util.GenericMessageInfoUtilQueue
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_detail.GetRecipe
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailEvents
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_detail.RecipeDetailState
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeListEvents
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
            is RecipeDetailEvents.OnRemoveHeadMessageFromQueue->{
                removeHeadMsg()
            }
            else ->
            {
                appendToMessageQueue(
                    GenericMessageInfo.Builder()
                        .id("RecuoeDetail.Error")
                        .title("Error")
                        .uiComponentType(UiComponentType.Dialog)
                        .description("Invalid Event").build())
            }

        }
    }

    private fun appendToMessageQueue(msgInfo: GenericMessageInfo)
    {
        if(!GenericMessageInfoUtilQueue().doesMessageAlready(
                queue = state.value.queue, messageInfo = msgInfo
            ))
        {
            val queue=state.value.queue
            queue.add(msgInfo)
            state.value=state.value.copy(queue = queue)
        }

    }

    private fun removeHeadMsg()
    {
        try
        {
            val queue=state.value.queue
            queue.remove()
            state.value=state.value.copy(queue = Queue(mutableListOf()))/*force recompose*/
            state.value=state.value.copy(queue = queue)

        }catch (e:Exception)
        {

        }
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
                appendToMessageQueue(message)
            }

        }.launchIn(viewModelScope)

    }

}