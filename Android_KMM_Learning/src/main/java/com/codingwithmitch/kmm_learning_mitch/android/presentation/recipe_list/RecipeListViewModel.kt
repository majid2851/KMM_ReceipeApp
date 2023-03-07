package com.codingwithmitch.kmm_learning_mitch.android.presentation.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo
import com.codingwithmitch.food2forkkmm.domain.model.NegativeAction
import com.codingwithmitch.food2forkkmm.domain.model.PositiveAction
import com.codingwithmitch.kmm_learning_mitch.domain.model.Recipe
import com.codingwithmitch.kmm_learning_mitch.domain.model.UiComponentType
import com.codingwithmitch.kmm_learning_mitch.domain.util.GenericMessageInfoUtilQueue
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue
import com.codingwithmitch.kmm_learning_mitch.interactors.recipe_list.SearchRecipes
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.FoodCategory
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeListEvents
import com.codingwithmitch.kmm_learning_mitch.presentation.recipe_list.RecipeStateList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

@HiltViewModel
class RecipeListViewModel
    @Inject constructor(private val savedStateHandle: SavedStateHandle,
                        private val searchRecipes:SearchRecipes) :ViewModel()
{
    val state:MutableState<RecipeStateList> = mutableStateOf(RecipeStateList())
    init {
        trigerEvent(RecipeListEvents.LoadRecipes)

        // EXAMPLE
//        testAlertMsg()

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
                state.value=state.value.copy(query = event.query, selectedCategory = null)
            }
            is RecipeListEvents.onSelectCategory->
            {

                selectCategory(event.category)
            }
            is RecipeListEvents.OnRemoveHeadMessageFromQueue->{
                removeHeadMsg()
            }
            else->
            {
                appendToMessageQueue(
                    GenericMessageInfo.Builder()
                    .id("RecipeList.Error")
                    .title("Error")
                    .uiComponentType(UiComponentType.Dialog)
                    .description("Invalid Event").build())
            }
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

    private fun selectCategory(category: FoodCategory) {
        state.value=state.value.copy(query = category.value, selectedCategory = category)
        newSearch()
    }

    private fun newSearch() {
        state.value=state.value.copy(page = 1, recipe = listOf())
        loadRecipe()

    }

    private fun appendToMessageQueue(msgInfo:GenericMessageInfo)
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


    private fun goNextPage()
    {
        state.value=state.value.copy(page = state.value.page+1)
        loadRecipe()
    }

    private fun loadRecipe()
    {
        searchRecipes.excute(page = state.value.page, query = state.value.query)
            .collectCommon(coroutineScope = viewModelScope)
            {dataState ->
                state.value=state.value.copy(isLoading = dataState.isLoading)
                Log.i("mag2851-loading",dataState.isLoading.toString())

                dataState.data?.let()
                {recipes->
                    appendRecipes(recipes = recipes)
                }
                dataState.message?.let()
                {message->
                    appendToMessageQueue(message)
                }


            }
    }
    private fun appendRecipes(recipes:List<Recipe>)
    {
        val curr=ArrayList(state.value.recipe)
        curr.addAll(recipes)
        state.value=state.value.copy(recipe = curr)


    }


    private fun testAlertMsg()
    {
        val messageInfoBuilder = GenericMessageInfo.Builder()
            .id(UUID.randomUUID().toString())
            .title("Weird")
            .uiComponentType(UiComponentType.Dialog)
            .description("I don't know what's happening.")
            .positive(PositiveAction(
                positiveBtnTxt = "OK",
                onPositiveAction = {
                    // do something special??
                    state.value = state.value.copy(query = "Kale")
                    trigerEvent(RecipeListEvents.newSearch)
                }
            ))
            .negative(NegativeAction(
                negativeBtnTxt = "Cancel",
                onNegativeAction = {
                    state.value = state.value.copy(query = "Cookies")
                    trigerEvent(RecipeListEvents.newSearch)
                }
            ))
        appendToMessageQueue(msgInfo = messageInfoBuilder.build())
    }


}