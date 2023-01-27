package com.codingwithmitch.kmm_learning_mitch.android

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.kmm_learning_mitch.android.presentation.navigation.Navigation
import com.codingwithmitch.kmm_learning_mitch.datasource.network.KtorClientFactory
import com.codingwithmitch.kmm_learning_mitch.datasource.network.model.RecipeDto
import com.codingwithmitch.kmm_learning_mitch.datasource.network.toRecipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DatetimeUtil
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
const val BASE_URL = "https://food2fork.ca/api/recipe"

@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{
    @OptIn(ExperimentalStdlibApi::class)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val ktorClient=KtorClientFactory().build()
        CoroutineScope(IO).launch {
            val recipeId=1551
            val recipeDto=ktorClient.get<RecipeDto>()
            {
                url("$BASE_URL/get?id=$recipeId")
//                url("$BASE_URL/search/?page=1&query=kale")
                header("Authorization", TOKEN)
            }.toRecipe()
            Log.i("mag2851","Ktor Test:${recipeDto.title}")
            Log.i("mag2851","Ktor Test:${recipeDto.ingredients}")
            Log.i("mag2851","Ktor Test:${DatetimeUtil().humanizeDatetime(recipeDto.dateUpdated)}")
        }


        setContent()
        {
            Navigation()
        }

    }
}
