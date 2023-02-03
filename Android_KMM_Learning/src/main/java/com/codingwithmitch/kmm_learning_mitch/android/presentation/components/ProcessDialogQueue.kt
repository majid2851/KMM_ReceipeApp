package com.codingwithmitch.kmm_learning_mitch.android.presentation.components

import androidx.compose.runtime.Composable
import com.codingwithmitch.food2forkkmm.domain.model.GenericMessageInfo
import com.codingwithmitch.kmm_learning_mitch.domain.util.Queue

@Composable
fun ProcessDialogQueue(dialogQueue: Queue<GenericMessageInfo>?)
{
    dialogQueue?.peek()?.let {
        GenericDialog(title = it.title,description = it.description)
    }
}