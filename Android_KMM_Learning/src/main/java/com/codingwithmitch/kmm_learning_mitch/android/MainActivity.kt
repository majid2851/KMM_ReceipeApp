package com.codingwithmitch.kmm_learning_mitch.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.codingwithmitch.kmm_learning_mitch.Greeting
import com.codingwithmitch.kmm_learning_mitch.android.presentation.navigation.Navigation

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent()
        {
            Navigation()
        }

    }
}
