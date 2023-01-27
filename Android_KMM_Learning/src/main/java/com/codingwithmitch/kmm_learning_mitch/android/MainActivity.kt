package com.codingwithmitch.kmm_learning_mitch.android

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.kmm_learning_mitch.android.presentation.navigation.Navigation
import com.codingwithmitch.kmm_learning_mitch.datasource.network.KtorClientFactory
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeServiceImpl
import com.codingwithmitch.kmm_learning_mitch.datasource.network.RecipeServiceImpl.Companion.BASE_URL
import com.codingwithmitch.kmm_learning_mitch.datasource.network.model.RecipeDto
import com.codingwithmitch.kmm_learning_mitch.datasource.network.toRecipe
import com.codingwithmitch.kmm_learning_mitch.domain.util.DatetimeUtil
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch



@AndroidEntryPoint
class MainActivity : AppCompatActivity()
{
    @OptIn(ExperimentalStdlibApi::class)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)




        setContent()
        {
            Navigation()
        }

    }
}
