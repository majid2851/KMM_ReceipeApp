package com.codingwithmitch.kmm_learning_mitch.android

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.kmm_learning_mitch.android.presentation.navigation.Navigation
import com.codingwithmitch.kmm_learning_mitch.datasource.network.KtorClientFactory
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
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        val ktorClient=KtorClientFactory().build()
        CoroutineScope(IO).launch {
            val recipeId=1551
            val recipe=ktorClient.get<String>()
            {
                url("$BASE_URL/get?id=$recipeId")
                header("Authorization", TOKEN)
            }
            Log.i("mag2851","Ktor Test:${recipe}")
        }


        setContent()
        {
            Navigation()
        }

    }
}
