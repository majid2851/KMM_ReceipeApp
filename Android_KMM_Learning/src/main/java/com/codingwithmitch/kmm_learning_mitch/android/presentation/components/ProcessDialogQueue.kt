package com.codingwithmitch.kmm_learning_mitch.android.presentation.components

import androidx.compose.runtime.Composable
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue

@Composable
fun ProcessDialogQueue(dialogQueue: Queue<String>?)
{
    dialogQueue?.peek()?.let {
        GenericDialog(title = "Error",description = it)
    }
}